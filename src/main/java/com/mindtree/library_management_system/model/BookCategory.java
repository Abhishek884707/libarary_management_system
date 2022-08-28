package com.mindtree.library_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BookCategory {

    @Id
    @GeneratedValue
    private int id;

    private String Name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "bookCategory")
    private List<Book> books = new ArrayList<>();

    public BookCategory() {
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

    public void addBook(Book book) {
        this.books.add(book);
    }

    public boolean removeBook(Book book){
        return this.books.remove(book);
    }

    public void setBooks(List<Book> books){
        this.books = books;
    }
}
