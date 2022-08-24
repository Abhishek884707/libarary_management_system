package com.mindtree.libarary_management_system.controller;

import com.mindtree.libarary_management_system.dto.StudentDto;
import com.mindtree.libarary_management_system.model.Student;
import com.mindtree.libarary_management_system.service.StudentService;
import com.mindtree.libarary_management_system.utilities.StudentUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("library_management_system/v1/")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    StudentService studentService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/student")
    public List<StudentDto> retrieveAllStudents(){
        List<Student> students = studentService.getAll();
        List<StudentDto> studentDtoList = students.stream().map(student -> StudentUtility.fromStudentToStudentDto(student)).collect(Collectors.toList());
        return studentDtoList;
    }

    @GetMapping("/student/{studentId}")
    public StudentDto getStudentById(@PathVariable("studentId") int id){
        log.info("{}",id);
        Student student = studentService.getStudentById(id).get();
        StudentDto studentDto = StudentUtility.fromStudentToStudentDto(student);
        log.info("{}", studentDto);
        return studentDto;
    }

    @PostMapping("/student")
    public StudentDto createNewStudent(@RequestBody StudentDto studentDto){
        log.info("{}", studentDto.toString());
        Student student = StudentUtility.fromStudentDtoToStudent(studentDto);
        studentDto = StudentUtility.fromStudentToStudentDto(studentService.addNewStudent(student));
        return studentDto;
    }

    @PutMapping("/student")
    public StudentDto editStudentDetails(@RequestBody StudentDto studentDto){
        log.info("{}", studentDto);
        Student student = StudentUtility.fromStudentDtoToStudent(studentDto);
        studentDto = StudentUtility.fromStudentToStudentDto(studentService.updateStudent(student));
        return studentDto;
    }

    @DeleteMapping("/student")
    public boolean removeStudent(@RequestBody StudentDto studentDto){
        log.info("{}", studentDto);
        Student student = StudentUtility.fromStudentDtoToStudent(studentDto);
        return studentService.deleteStudent(student);

    }


}
