package com.mindtree.library_management_system.dto;

import com.mindtree.library_management_system.enums.AddressType;
import com.mindtree.library_management_system.model.Student;

public class AddressDto {

    private int id;

    private String streetAddress;

    private String city;

    private String State;

    private int zipcode;

    private String country;

    private Student student;

    private AddressType addressType;

    public AddressDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", State='" + State + '\'' +
                ", zipcode=" + zipcode +
                ", country='" + country + '\'' +
                ", student=" + student +
                ", addressType=" + addressType +
                '}';
    }
}
