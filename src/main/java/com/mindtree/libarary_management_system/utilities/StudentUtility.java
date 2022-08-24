package com.mindtree.libarary_management_system.utilities;

import com.mindtree.libarary_management_system.dto.StudentDto;
import com.mindtree.libarary_management_system.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

public class StudentUtility {

    static Logger log = LoggerFactory.getLogger(StudentUtility.class);

    public static Student fromStudentDtoToStudent(StudentDto studentDto){
        Student student = new Student();

        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEnrollmentNumber(studentDto.getEnrollmentNumber());
        student.setPursuingYear(studentDto.getPursuingYear());
        student.setStatus(studentDto.getStatus());
        student.setAddress(studentDto.getAddress());
        student.setCourse(studentDto.getCourse());
        student.setBorrows(studentDto.getBorrows());
        student.setGroupMember(studentDto.getGroupMember());
        student.setContactNumber(studentDto.getContactNumber());
        student.setFatherName(studentDto.getFatherName());
        student.setMotherName(studentDto.getMotherName());

        return student;

    }

    public static StudentDto fromStudentToStudentDto(Student student){
        StudentDto studentDto = new StudentDto();

        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEnrollmentNumber(student.getEnrollmentNumber());
        studentDto.setPursuingYear(student.getPursuingYear());
        studentDto.setStatus(student.getStatus());
        studentDto.setCourse(student.getCourse());
        studentDto.setAddress(student.getAddress());
        studentDto.setBorrows(student.getBorrows());
        studentDto.setGroupMember(student.getGroupMember());
        studentDto.setContactNumber(student.getContactNumber());
        studentDto.setFatherName(student.getFatherName());
        studentDto.setMotherName(student.getMotherName());
        return studentDto;

    }

}
