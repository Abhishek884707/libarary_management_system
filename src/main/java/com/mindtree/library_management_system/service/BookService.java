package com.mindtree.library_management_system.service;

import com.mindtree.library_management_system.model.Book;
import com.mindtree.library_management_system.model.BookCategory;
import com.mindtree.library_management_system.model.Course;
import com.mindtree.library_management_system.model.Student;
import com.mindtree.library_management_system.repository.BookCategoryRepository;
import com.mindtree.library_management_system.repository.BookRepository;
import com.mindtree.library_management_system.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public List<Book> getBooksByName(String name){
        Optional<List<Book>> books = bookRepository.findByNameContainingIgnoreCase(name);
        if (books.isPresent()){
            return books.get();
        }
        return null;
    }

    public Book addNewBook(Book book) {
        Optional<BookCategory> bookCategory = bookCategoryRepository.findById(book.getBookCategory().getId());
        if (bookCategory.isPresent()){
            book.setBookCategory(bookCategory.get());
        }
        Optional<Course> course = null;
        if(book.getCourse().getId() != 0){
            course = courseRepository.findById(book.getCourse().getId());
            if(course.isPresent()){
                book.setCourse(course.get());
            }
        }else{
            book.setCourse(null);
            System.err.println("Course Set to Null");
        }
        book = bookRepository.save(book);
        if(course != null){
            course.get().addBook(book);
            courseRepository.save(course.get());
        }
        bookCategory.get().addBook(book);
        bookCategoryRepository.save(bookCategory.get());
        return book;
    }

    public Book updateBook(Book book) {
        Optional<Book> optionalBook = this.getBookById(book.getId());
        Course course;
        if(optionalBook.isPresent()){
            optionalBook.get().setAuthorName(book.getAuthorName());
            optionalBook.get().setName(book.getName());
            optionalBook.get().setBookStatus(book.getBookStatus());

            if(book.getCourse() != null){
                if(optionalBook.get().getCourse() != null){
                    if(optionalBook.get().getCourse().getId() != book.getCourse().getId()){
                        course = courseRepository.findById(optionalBook.get().getCourse().getId()).get();
                        course.removeBook(optionalBook.get());
                        courseRepository.save(course);
                        course = courseRepository.findById(book.getCourse().getId()).get();
                        course.addBook(optionalBook.get());
                        course = courseRepository.save(course);
                        optionalBook.get().setCourse(course);
                    }
                }else{
                    course = courseRepository.findById(book.getCourse().getId()).get();
                    optionalBook.get().setCourse(course);
                }
            }else{
                optionalBook.get().setCourse(null);
            }

            if(optionalBook.get().getBookCategory().getId() != book.getBookCategory().getId()){
                BookCategory  bookCategory = bookCategoryRepository.findById(optionalBook.get().getBookCategory().getId()).get();
                bookCategory.removeBook(optionalBook.get());
                bookCategoryRepository.save(bookCategory);
                bookCategory = bookCategoryRepository.findById(book.getBookCategory().getId()).get();
                bookCategory.addBook(optionalBook.get());
                bookCategory = bookCategoryRepository.save(bookCategory);
                optionalBook.get().setBookCategory(bookCategory);
            }

        }
        return bookRepository.save(optionalBook.get());
    }

    public boolean removeBook(Book book) {
        if(this.getBookById(book.getId()).isPresent()){
            bookRepository.delete(book);
            return true;
        }
        return false;
    }


}
