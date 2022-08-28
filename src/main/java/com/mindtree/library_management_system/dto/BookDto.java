package com.mindtree.library_management_system.dto;

import com.mindtree.library_management_system.enums.BookStatus;
import com.mindtree.library_management_system.model.BookCategory;
import com.mindtree.library_management_system.model.Borrowed;
import com.mindtree.library_management_system.model.Course;

public class BookDto {

    private int id;

    private String name;

    private Course course;

    private String authorName;

    private BookCategory bookCategory;

    private BookStatus bookStatus;

    private Borrowed borrowed;

    public BookDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Borrowed getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Borrowed borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", course=" + course +
                ", authorName='" + authorName + '\'' +
                ", bookCategory=" + bookCategory +
                ", bookStatus=" + bookStatus +
                ", borrowed=" + borrowed +
                '}';
    }
}
