package com.mindtree.library_management_system.dto;

import com.mindtree.library_management_system.model.Book;
import com.mindtree.library_management_system.model.Student;

public class BorrowedDto {

    private int id;

    private Book book;

    private Student student;
//    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private String issuedDate;

    private int renewedCount;

    public BorrowedDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }


    public int getRenewedCount() {
        return renewedCount;
    }

    public void setRenewedCount(int renewedCount) {
        this.renewedCount = renewedCount;
    }

    @Override
    public String toString() {
        return "BorrowedDto{" +
                "id=" + id +
                ", book=" + book +
                ", student=" + student +
                ", issuedDate=" + issuedDate +
                ", renewedCount=" + renewedCount +
                '}';
    }
}
