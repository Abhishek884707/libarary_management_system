package com.mindtree.libarary_management_system.controller;

import com.mindtree.libarary_management_system.dto.BookCategoryDto;
import com.mindtree.libarary_management_system.model.BookCategory;
import com.mindtree.libarary_management_system.service.BookCategoryService;
import com.mindtree.libarary_management_system.utilities.BookUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("library_management_system/v1/")
@CrossOrigin("*")
public class BookCategoryController {

    @Autowired
    BookCategoryService bookCategoryService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("book_category")
    public List<BookCategoryDto> retrieveAllBookCategory(){
        List<BookCategoryDto> bookCategoryDtoList = bookCategoryService.getAll().stream().map(bookCategory -> BookUtility.fromBookCategoryToBookCategoryDto(bookCategory)).collect(Collectors.toList());
        return bookCategoryDtoList;
    }

    @GetMapping("/book_category/{bookCategoryId}")
    public BookCategoryDto getBookCategoryById(@PathVariable("bookCategoryId") int id){
        log.info("{}",id);
        BookCategoryDto bookCategoryDto = BookUtility.fromBookCategoryToBookCategoryDto(bookCategoryService.getBookCategoryById(id).get());
        return bookCategoryDto;
    }

    @PostMapping("/book_category")
    public BookCategoryDto createNewBookCategory(@RequestBody BookCategoryDto bookCategoryDto){
        log.info("{}", bookCategoryDto);
        BookCategory bookCategory = BookUtility.fromBookCategoryDtoToBookCategory(bookCategoryDto);
        bookCategoryDto = BookUtility.fromBookCategoryToBookCategoryDto(bookCategoryService.addNewBookCategory(bookCategory));
        return bookCategoryDto;
    }

    @PutMapping("/book_category")
    public BookCategoryDto editBookCategory(@RequestBody BookCategoryDto bookCategoryDto){
        log.info("{}", bookCategoryDto);
        BookCategory bookCategory = BookUtility.fromBookCategoryDtoToBookCategory(bookCategoryDto);
        bookCategoryDto = BookUtility.fromBookCategoryToBookCategoryDto(bookCategoryService.updateBookCategory(bookCategory));
        return bookCategoryDto;
    }

    @DeleteMapping("/book_category")
    public boolean removeBookCategory(@RequestBody BookCategoryDto bookCategoryDto){
        log.info("{}", bookCategoryDto);
        BookCategory bookCategory = BookUtility.fromBookCategoryDtoToBookCategory(bookCategoryDto);
        return bookCategoryService.removeBookCategory(bookCategory);
    }


}
