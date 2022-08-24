package com.mindtree.libarary_management_system.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.libarary_management_system.enums.BookStatus;
import com.mindtree.libarary_management_system.model.BookCategory;
import com.mindtree.libarary_management_system.model.Borrowed;
import com.mindtree.libarary_management_system.model.Course;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class BookDto {

    private int id;

    private String Name;

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
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
                ", Name='" + Name + '\'' +
                ", course=" + course +
                ", authorName='" + authorName + '\'' +
                ", bookCategory=" + bookCategory +
                ", bookStatus=" + bookStatus +
                ", borrowed=" + borrowed +
                '}';
    }
}
