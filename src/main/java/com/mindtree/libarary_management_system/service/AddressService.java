package com.mindtree.libarary_management_system.service;

import com.mindtree.libarary_management_system.model.Address;
import com.mindtree.libarary_management_system.model.Student;
import com.mindtree.libarary_management_system.repository.AddressRepository;
import com.mindtree.libarary_management_system.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public Address addNewAddress(Address address){

        Student student = studentRepository.findById(address.getStudent().getId()).get();
        address.setStudent(student);
        address = addressRepository.save(address);
        student.setAddress(address);
        studentRepository.save(student);
        return address;
    }

    public Optional<Address> getAddressById(int id){
        return addressRepository.findById(id);
    }

    public Address updateAddress(Address address){

        Student student = studentRepository.findById(address.getStudent().getId()).get();
        address.setStudent(student);
        address = addressRepository.save(address);
        student.setAddress(address);
        studentRepository.save(student);
        return address;
    }

    public boolean deleteAddress(Address address){
        log.info("{}",address.getId());
        log.info("{}",address.getStudent().getId());
        if(this.getAddressById(address.getId()).isPresent()){
            Student student = studentRepository.findById(address.getStudent().getId()).get();
            student.setAddress(null);
            studentRepository.save(student);
            address.setStudent(null);
            addressRepository.delete(address);
            return true;
        }
        return false;
    }

}
