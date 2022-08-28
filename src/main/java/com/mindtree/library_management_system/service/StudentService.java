package com.mindtree.library_management_system.service;

import com.mindtree.library_management_system.model.Course;
import com.mindtree.library_management_system.model.Student;
import com.mindtree.library_management_system.repository.CourseRepository;
import com.mindtree.library_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressService addressService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    GroupService groupService;

    @Transactional
    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public Student addNewStudent(Student student) {

        Optional<Course> optCourse  = courseRepository.findById(student.getCourse().getId());
        Course course = optCourse.get();

        if(optCourse.isPresent()){
            student.setCourse(optCourse.get());
        }

        Student savedStudent = studentRepository.save(student);
        course.addStudent(savedStudent);
        courseRepository.save(course);

        return savedStudent;
    }

    @Transactional
    public Student updateStudent(Student student) {

        Student  optStudent = this.getStudentById(student.getId()).get();
        Course course;
        if(optStudent.getCourse().getId() != student.getCourse().getId()){
            course = courseRepository.findById(optStudent.getCourse().getId()).get();
            course.removeStudent(optStudent);
            courseRepository.save(course);
            course = courseRepository.findById(student.getCourse().getId()).get();
            course.addStudent(optStudent);
            course = courseRepository.save(course);
            optStudent.setCourse(course);
        }

        optStudent.setFirstName(student.getFirstName());
        optStudent.setLastName(student.getLastName());
        optStudent.setContactNumber(student.getContactNumber());
        optStudent.setFatherName(student.getFatherName());
        optStudent.setMotherName(student.getMotherName());

        return studentRepository.save(optStudent);
    }

    public boolean deleteStudent(Student student) {

        if(this.getStudentById(student.getId()).isPresent()){

            return true;
        }
        return false;
    }
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByName(String name){
        Optional<List<Student>> students = studentRepository.findByFirstNameOrLastName(name, name);
        if (students.isPresent()){
            return students.get();
        }
        return null;
    }

}
