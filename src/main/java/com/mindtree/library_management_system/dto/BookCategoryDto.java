package com.mindtree.library_management_system.dto;

import com.mindtree.library_management_system.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookCategoryDto {

    private int id;

    private String Name;

    private List<Book> books = new ArrayList<>();

    public BookCategoryDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookCategoryDto{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", books=" + books +
                '}';
    }
}
