package com.mindtree.library_management_system.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Borrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Book book;

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Student student;

    private LocalDateTime issuedDate;

    private int renewedCount;

    public Borrowed() {
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

    public LocalDateTime getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDateTime issuedDate) {
        this.issuedDate = issuedDate;
    }


    public int getRenewedCount() {
        return renewedCount;
    }

    public void setRenewedCount(int renewedCount) {
        this.renewedCount = renewedCount;
    }

}
