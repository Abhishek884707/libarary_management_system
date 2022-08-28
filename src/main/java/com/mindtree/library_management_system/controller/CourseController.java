package com.mindtree.library_management_system.controller;

import com.mindtree.library_management_system.dto.CourseDto;
import com.mindtree.library_management_system.model.Course;
import com.mindtree.library_management_system.service.CourseService;
import com.mindtree.library_management_system.utilities.CourseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("library_management_system/v1/")
@CrossOrigin("*")
public class CourseController {

    @Autowired
    CourseService courseService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/course")
    public List<CourseDto> retrieveAllCourse(){
        List<Course> courses = courseService.getAll();
        List<CourseDto> courseDtos = courses.stream().map(course -> CourseUtility.fromCourseToCourseDto(course)).collect(Collectors.toList());
        return courseDtos;
    }

    @GetMapping("/course/{courseId}")
    public CourseDto getCourseById(@PathVariable("courseId") int id){
        log.info("{}",id);

        CourseDto courseDto = CourseUtility.fromCourseToCourseDto(courseService.getCourseById(id).get());

        return courseDto;
    }

    @PostMapping("/course")
    public CourseDto createNewCourse(@RequestBody CourseDto coursedto){
        log.info("{}", coursedto);

        Course course = CourseUtility.fromCourseDtoToCourse(coursedto);
        coursedto = CourseUtility.fromCourseToCourseDto(courseService.addNewCourse(course).get());
        return coursedto;
    }

    @PutMapping("/course")
    public CourseDto editCourse(@RequestBody CourseDto courseDto){
        log.info("{}", courseDto);
        Course course = CourseUtility.fromCourseDtoToCourse(courseDto);
        courseDto = CourseUtility.fromCourseToCourseDto(courseService.updateCourse(course));
        return courseDto;
    }

    @DeleteMapping("/course")
    public boolean removeCourse(@RequestBody Course course){
        log.info("{}", course);
        return courseService.deleteCourse(course);
    }


}
