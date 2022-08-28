package com.mindtree.library_management_system.service;

import com.mindtree.library_management_system.model.BookCategory;
import com.mindtree.library_management_system.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCategoryService {

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    public Optional<BookCategory> getBookCategoryById(int id) {
        return bookCategoryRepository.findById(id);
    }

    public List<BookCategory> getAll(){
        return bookCategoryRepository.findAll();
    }

    public BookCategory addNewBookCategory(BookCategory bookCategory) {
        return bookCategoryRepository.save(bookCategory);
    }

    public BookCategory updateBookCategory(BookCategory bookCategory) {
        Optional<BookCategory> optionalBookCategory = this.getBookCategoryById(bookCategory.getId());
        if(optionalBookCategory.isPresent()){
            optionalBookCategory.get().setName(bookCategory.getName());
        }
        return bookCategoryRepository.save(optionalBookCategory.get());
    }

    public boolean removeBookCategory(BookCategory bookCategory) {
        if(this.getBookCategoryById(bookCategory.getId()).isPresent()){
            bookCategoryRepository.delete(bookCategory);
            return true;
        }
        return false;
    }


}
