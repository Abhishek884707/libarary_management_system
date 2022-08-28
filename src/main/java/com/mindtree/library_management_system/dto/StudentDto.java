package com.mindtree.library_management_system.dto;

import com.mindtree.library_management_system.enums.StudentStatus;
import com.mindtree.library_management_system.model.*;

import java.util.List;

public class StudentDto {

    private int id;

    private String firstName;

    private String lastName;

    private Long enrollmentNumber;

    private Address address;

    private int pursuingYear;

    private Course course;

    private StudentStatus status;

    private List<Borrowed> borrows;

    private GroupName groupName;

    private List<Fine>  fines;
    private String contactNumber;

    private String fatherName;

    private String motherName;

    public StudentDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) { this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(Long enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getPursuingYear() {
        return pursuingYear;
    }

    public void setPursuingYear(int pursuingYear) {
        this.pursuingYear = pursuingYear;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public List<Borrowed> getBorrows() {
        return borrows;
    }
    public GroupName getGroupName() {
        return groupName;
    }

    public void setGroupName(GroupName groupName) {
        this.groupName = groupName;
    }

    public void setBorrows(List<Borrowed> borrows){
        this.borrows = borrows;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void setFines(List<Fine> fine) {
        this.fines = fine;
    }

}
