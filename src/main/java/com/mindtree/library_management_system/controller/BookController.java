package com.mindtree.library_management_system.controller;

import com.mindtree.library_management_system.dto.BookDto;
import com.mindtree.library_management_system.model.Book;
import com.mindtree.library_management_system.service.BookService;
import com.mindtree.library_management_system.utilities.BookUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("library_management_system/v1/")
@CrossOrigin("*")
public class BookController {

    @Autowired
    BookService bookService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/book")
    public List<BookDto> reteriveAllBook(){
        List<BookDto> BookDtoList = bookService.getAll().stream().map(book -> BookUtility.fromBookToBookDto(book)).collect(Collectors.toList());
        return BookDtoList;
    }

    @GetMapping("/book/search/{search}")
    public List<BookDto> searchBookByName(@PathVariable("search") String search){
        List<BookDto> BookDtoList = bookService.getBooksByName(search).stream().map(book -> BookUtility.fromBookToBookDto(book)).collect(Collectors.toList());
        return BookDtoList;
    }

    @GetMapping("/book/{bookId}")
    public BookDto getBookById(@PathVariable("bookId") int id){
        log.info("{}",id);
        BookDto BookDto = BookUtility.fromBookToBookDto(bookService.getBookById(id).get());
        return BookDto;
    }

    @PostMapping("/book")
    public BookDto createNewBook(@RequestBody BookDto bookDto){
        log.info("{}", bookDto.toString());
        System.err.println(bookDto.getCourse().getName());
        System.err.println(bookDto.getBookCategory().getName());
        Book book = BookUtility.fromBookDtoToBook(bookDto);
        bookDto = BookUtility.fromBookToBookDto(bookService.addNewBook(book));
        return bookDto;
    }

    @PutMapping("/book")
    public BookDto editBook(@RequestBody BookDto bookDto){
        log.info("{}", bookDto);
        Book book = BookUtility.fromBookDtoToBook(bookDto);
        bookDto = BookUtility.fromBookToBookDto(bookService.updateBook(book));
        return bookDto;
    }

    @DeleteMapping("/book")
    public boolean removeBook(@RequestBody BookDto bookDto){
        log.info("{}", bookDto);
        Book book = BookUtility.fromBookDtoToBook(bookDto);
        return bookService.removeBook(book);
    }



}
