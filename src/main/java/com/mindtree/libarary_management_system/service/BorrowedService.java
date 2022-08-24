package com.mindtree.libarary_management_system.service;

import com.mindtree.libarary_management_system.enums.BookStatus;
import com.mindtree.libarary_management_system.model.Book;
import com.mindtree.libarary_management_system.model.Borrowed;
import com.mindtree.libarary_management_system.model.Student;
import com.mindtree.libarary_management_system.repository.BookRepository;
import com.mindtree.libarary_management_system.repository.BorrowedRepository;
import com.mindtree.libarary_management_system.repository.StudentRepository;
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

    static final int TEXT = 15;
    static final int REFERENCE = 7;

    static final int JOURNAL = 2;


    public List<Borrowed> getAllBorrowed() {
        return borrowedRepository.findAll();
    }

    public Optional<Borrowed> getBorrowedById(int id) {
        return borrowedRepository.findById(id);
    }

    public Borrowed addNewBorrowed(Borrowed borrowed) {

        Optional<Student> optionalStudent = studentRepository.findById(borrowed.getStudent().getId());
        Optional<Book> optionalBook = bookRepository.findById(borrowed.getBook().getId());

        Student student;
        Book book;
        if (optionalStudent.isPresent() && optionalBook.isPresent()) {
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
                borrowed = this.returnBook(optionalBorrowed.get(), fyn);
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



    public static boolean deleteBorrowed(Borrowed borrowed) {

        return false;
    }
    private double calculateFyn(Borrowed borrowed) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date firstDate = sdf.parse(borrowed.getIssuedDate().toString());
            Date secondDate = sdf.parse(borrowed.getReturnDate().toString());
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

    public Borrowed returnBook(Borrowed borrowed,Double fyn){
        borrowed.setFine(fyn);
        borrowed.setReturnDate(LocalDateTime.now());
        Book book = bookRepository.findById(borrowed.getBook().getId()).get();
        book.setBookStatus(BookStatus.AVAILABLE);
        bookRepository.save(book);

        borrowed = borrowedRepository.save(borrowed);

        return borrowed;
    }

    public Borrowed renewBook(Borrowed borrowed, Double fyn){
//        this.returnBook(borrowed,fyn);
        int renewCount = borrowed.getRenewedCount() + 1;
        borrowed.setRenewedCount(renewCount);

        borrowed = borrowedRepository.save(borrowed);

        return borrowed;
    }

    public Borrowed transferBook(Borrowed borrowed,Double fyn, Student student){
        this.returnBook(borrowed, fyn);
        int renewCount = borrowed.getRenewedCount() + 1;
        borrowed.setRenewedCount(renewCount);
        borrowed.setStudent(student);
        borrowed.setIssuedDate(LocalDateTime.now());

        return this.addNewBorrowed(borrowed);
    }
}
