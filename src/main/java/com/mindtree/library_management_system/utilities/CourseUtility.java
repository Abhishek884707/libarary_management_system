package com.mindtree.library_management_system.utilities;

import com.mindtree.library_management_system.dto.CourseDto;
import com.mindtree.library_management_system.model.Course;

public class CourseUtility {

    public static CourseDto fromCourseToCourseDto(Course course){
        CourseDto courseDto = new CourseDto();

        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setDuration(course.getDuration());
        courseDto.setBooks(course.getBooks());
        courseDto.setStudents(course.getStudents());

        return courseDto;
    }

    public static Course fromCourseDtoToCourse(CourseDto courseDto){
        Course course = new Course();

        course.setId(courseDto.getId());
        course.setName(courseDto.getName());
        course.setDuration(courseDto.getDuration());
        course.setBooks(courseDto.getBooks());
        course.setStudents(courseDto.getStudents());

        return course;
    }
}
