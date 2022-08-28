package com.mindtree.library_management_system.service;

import com.mindtree.library_management_system.enums.BookStatus;
import com.mindtree.library_management_system.model.Book;
import com.mindtree.library_management_system.model.Borrowed;
import com.mindtree.library_management_system.model.Fine;
import com.mindtree.library_management_system.model.Student;
import com.mindtree.library_management_system.repository.BookRepository;
import com.mindtree.library_management_system.repository.BorrowedRepository;
import com.mindtree.library_management_system.repository.FineRepository;
import com.mindtree.library_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class BorrowedService {

    @Autowired
    BorrowedRepository borrowedRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    FineRepository fineRepository;

    static final int TEXT = 15;
    static final int REFERENCE = 7;

    static final int JOURNAL = 2;


    public List<Borrowed> getAllBorrowed() {
        return borrowedRepository.findAll();
    }

    public Optional<Borrowed> getBorrowedById(int id) {
        return borrowedRepository.findById(id);
    }

    public List<Borrowed> searchIntoBorrows(String name){
        Optional<List<Borrowed>> borrows = borrowedRepository.findBorrowed(name, name, name);
        if (borrows.isPresent()){
            return borrows.get();
        }
        return null;
    }

    public Borrowed addNewBorrowed(Borrowed borrowed) {

        Optional<Student> optionalStudent = studentRepository.findById(borrowed.getStudent().getId());
        Optional<Book> optionalBook = bookRepository.findById(borrowed.getBook().getId());

        Student student;
        Book book;
        if (optionalStudent.isPresent() && optionalBook.isPresent()) {
            System.err.println("yes data is presented.");
            borrowed.setStudent(optionalStudent.get());
            borrowed.setBook(optionalBook.get());
            optionalBook.get().setBookStatus(BookStatus.OCCUPIED);
            borrowed.setIssuedDate(LocalDateTime.now());
        }

        borrowed = borrowedRepository.save(borrowed);

        optionalBook.get().setBorrowed(borrowed);
        optionalStudent.get().addBorrow(borrowed);
        bookRepository.save(optionalBook.get());
        studentRepository.save(optionalStudent.get());
        return borrowed;
    }

    public Borrowed updateBorrowed(Borrowed borrowed, String operation) {
        Optional<Borrowed> optionalBorrowed = this.getBorrowedById(borrowed.getId());
        if (optionalBorrowed.isPresent()) {

            double fyn = calculateFyn(optionalBorrowed.get());
            if(operation.contains("return")){
                 this.returnBook(optionalBorrowed.get(), fyn);
            }else if(operation.contains("renew")){
                borrowed = this.renewBook(optionalBorrowed.get(), fyn);
            }else if(operation.contains("transfer") && optionalBorrowed.get().getBook().getBookCategory().getName().toLowerCase().contains("reference")){
                Optional<Student> optionalStudent = studentRepository.findById(borrowed.getStudent().getId());
                    if(optionalStudent.isPresent()){
                        borrowed = this.transferBook(optionalBorrowed.get(), fyn, borrowed.getStudent());
                    }
            }

        }

        return borrowed;
    }



    public boolean deleteBorrowed(Borrowed borrowed) {
        Book book = bookRepository.findById(borrowed.getBook().getId()).get();
        book.setBookStatus(BookStatus.AVAILABLE);
        book.setBorrowed(null);

        Student student = studentRepository.findById(borrowed.getStudent().getId()).get();
        student.removeBorrow(borrowed);


        borrowedRepository.delete(borrowed);
//        bookRepository.save(book);
//        studentRepository.save(student);

        return true;
    }
    private double calculateFyn(Borrowed borrowed) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date firstDate = sdf.parse(borrowed.getIssuedDate().toString());
            Date secondDate = sdf.parse(LocalDateTime.now().toString());
            long difference_In_Time
                    = firstDate.getTime() - secondDate.getTime();

            long difference_In_Days
                    = (difference_In_Time
                    / (1000 * 60 * 60 * 24))
                    % 365;
            if (borrowed.getBook().getBookCategory().getName().toLowerCase().contains("text")) {
                if (difference_In_Days > TEXT) {
                    long fyn = difference_In_Time - TEXT;
                    return (fyn * 5);
                }
            } else if (borrowed.getBook().getBookCategory().getName().toLowerCase().contains("reference")) {
                if (difference_In_Days > REFERENCE) {
                    long fyn = difference_In_Time - REFERENCE;
                    return (fyn * 5);
                }
            } else if (borrowed.getBook().getBookCategory().getName().toLowerCase().contains("journal")) {
                if (difference_In_Days > JOURNAL) {
                    long fyn = difference_In_Time - JOURNAL;
                    return (fyn * 5);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return 0;
        }

    }

    public Boolean returnBook(Borrowed borrowed,Double fyn){

        Fine fine = new Fine();
        if(fyn > 0){
            fine.setStudent(borrowed.getStudent());
            fine.setBook(borrowed.getBook());
            fine.setAmount(fyn);
            fine.setIssuedDate(borrowed.getIssuedDate());
            fine.setReturnedDate(LocalDateTime.now());
            fine = fineRepository.save(fine);
            Student student = studentRepository.findById(borrowed.getStudent().getId()).get();
            student.addFine(fine);
            studentRepository.save(student);
        }

       return this.deleteBorrowed(borrowed);
    }

    public Borrowed renewBook(Borrowed borrowed, Double fyn){
        Optional<Student> optionalStudent = studentRepository.findById(borrowed.getStudent().getId());
        Optional<Book> optionalBook = bookRepository.findById(borrowed.getBook().getId());
        Borrowed savedBorrowed = new Borrowed();
        savedBorrowed.setBook(optionalBook.get());
        savedBorrowed.setStudent(optionalStudent.get());
        savedBorrowed.setRenewedCount(borrowed.getRenewedCount() + 1);
        savedBorrowed.setIssuedDate(LocalDateTime.now());
        this.returnBook(borrowed,fyn);

        if(optionalStudent.isPresent() && optionalStudent.isPresent()){
            System.err.print("Student Id : " + savedBorrowed.getStudent().getId());
            System.err.println("Book Id : " +  savedBorrowed.getBook().getId());
        }


        savedBorrowed = this.addNewBorrowed(savedBorrowed);

//        optionalBook.get().setBorrowed(savedBorrowed);
//        optionalBook.get().setBookStatus(BookStatus.OCCUPIED);
//        optionalStudent.get().addBorrow(savedBorrowed);
//
//        studentRepository.save(optionalStudent.get());
//        bookRepository.save(optionalBook.get());

        return savedBorrowed;
    }

    public Borrowed transferBook(Borrowed borrowed,Double fyn, Student student){
        Optional<Student> optionalStudent = studentRepository.findById(borrowed.getStudent().getId());
        Optional<Book> optionalBook = bookRepository.findById(borrowed.getBook().getId());
        Borrowed savedBorrowed = new Borrowed();
        savedBorrowed.setBook(optionalBook.get());
        savedBorrowed.setStudent(student);
        savedBorrowed.setRenewedCount(borrowed.getRenewedCount() + 1);
        savedBorrowed.setIssuedDate(LocalDateTime.now());

        this.returnBook(borrowed, fyn);

        return this.addNewBorrowed(savedBorrowed);
    }
}
