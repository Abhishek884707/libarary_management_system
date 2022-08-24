package com.mindtree.libarary_management_system.service;

import com.mindtree.libarary_management_system.model.Course;
import com.mindtree.libarary_management_system.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAll() {
        return courseRepository.findAll();
    }
    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    public Optional<Course> addNewCourse(Course course) {
        return Optional.of(courseRepository.save(course));
    }

    public Course updateCourse(Course course) {
        Optional<Course> optCourse = courseRepository.findById(course.getId());
        if(optCourse.isPresent()){
            optCourse.get().setDuration(course.getDuration());
            optCourse.get().setName(course.getName());
        }
        return courseRepository.save(optCourse.get());
    }

    public boolean deleteCourse(Course course) {
        if(this.getCourseById(course.getId()).isPresent()){
            courseRepository.delete(course);
            return true;
        }
        return false;
    }

}
