package com.mindtree.library_management_system.utilities;

import com.mindtree.library_management_system.dto.BookCategoryDto;
import com.mindtree.library_management_system.dto.BookDto;
import com.mindtree.library_management_system.model.Book;
import com.mindtree.library_management_system.model.BookCategory;

public class BookUtility {

    public static BookCategoryDto fromBookCategoryToBookCategoryDto(BookCategory bookCategory){

        BookCategoryDto bookCategoryDto = new BookCategoryDto();

        bookCategoryDto.setId(bookCategory.getId());
        bookCategoryDto.setName(bookCategory.getName());
        bookCategoryDto.setBooks(bookCategory.getBooks());

        return bookCategoryDto;

    }

    public static BookCategory fromBookCategoryDtoToBookCategory(BookCategoryDto bookCategoryDto){

        BookCategory bookCategory = new BookCategory();

        bookCategory.setBooks(bookCategoryDto.getBooks());
        bookCategory.setId(bookCategoryDto.getId());
        bookCategory.setName(bookCategoryDto.getName());

        return bookCategory;
    }

    public static BookDto fromBookToBookDto(Book book){
        BookDto bookDto = new BookDto();

        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setCourse(book.getCourse());
        bookDto.setAuthorName(book.getAuthorName());
        bookDto.setBookStatus(book.getBookStatus());
        bookDto.setBookCategory(book.getBookCategory());
        bookDto.setBorrowed(book.getBorrowed());

        return bookDto;
    }

    public static Book fromBookDtoToBook(BookDto bookDto){
        Book book = new Book();

        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setCourse(bookDto.getCourse());
        book.setAuthorName(bookDto.getAuthorName());
        book.setBookCategory(bookDto.getBookCategory());
        book.setBookStatus(bookDto.getBookStatus());
        book.setBorrowed(bookDto.getBorrowed());

        return book;
    }
}
