package com.mindtree.library_management_system.dto;

import com.mindtree.library_management_system.model.Book;
import com.mindtree.library_management_system.model.Student;

import java.util.List;

public class CourseDto {

    private int id;

    private String Name;
    private int duration;

    private List<Book> books;

    private List<Student> students;

    public CourseDto() {
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", duration=" + duration +
                ", books=" + books +
                ", students=" + students +
                '}';
    }
}
