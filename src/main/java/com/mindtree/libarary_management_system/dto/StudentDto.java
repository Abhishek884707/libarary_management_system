package com.mindtree.libarary_management_system.dto;

import com.mindtree.libarary_management_system.enums.StudentStatus;
import com.mindtree.libarary_management_system.model.Address;
import com.mindtree.libarary_management_system.model.Borrowed;
import com.mindtree.libarary_management_system.model.Course;
import com.mindtree.libarary_management_system.model.GroupMember;

import javax.persistence.*;
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

    private GroupMember groupMember;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public void setBorrows(List<Borrowed> borrows) {
        this.borrows = borrows;
    }

    public GroupMember getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(GroupMember groupMember) {
        this.groupMember = groupMember;
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

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enrollmentNumber=" + enrollmentNumber +
                ", address=" + address +
                ", pursuingYear=" + pursuingYear +
                ", course=" + course +
                ", status=" + status +
                ", borrows=" + borrows +
                ", groupMember=" + groupMember +
                ", contactNumber='" + contactNumber + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                '}';
    }
}
