package com.mindtree.libarary_management_system;

import com.mindtree.libarary_management_system.enums.StudentStatus;
import com.mindtree.libarary_management_system.model.Course;
import com.mindtree.libarary_management_system.model.Student;
import com.mindtree.libarary_management_system.repository.CourseRepository;
import com.mindtree.libarary_management_system.repository.StudentRepository;
import com.mindtree.libarary_management_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {

/*
		//Adding Courses
		Course course1 = new Course();
		course1.setName("M.Sc Integrated programme Information Systems");
		course1.setDuration(5);
		course1.setBooks(null);
		course1.setStudents(null);

		Course course2 = new Course();
		course2.setName("M.Sc Integrated programme Software Systems");
		course2.setDuration(5);
		course2.setBooks(null);
		course2.setStudents(null);

		Course course3 = new Course();
		course3.setName("Bachelors in Technology Computer Science");
		course3.setDuration(4);
		course3.setBooks(null);
		course3.setStudents(null);

		Course course4 = new Course();
		course4.setName("Bachelors in Technology Mechanical Engg");
		course4.setDuration(4);
		course4.setBooks(null);
		course4.setStudents(null);

		Course course5 = new Course();
		course5.setName("Bachelors in Technology Chemical Engg");
		course5.setDuration(4);
		course5.setBooks(null);
		course5.setStudents(null);

		Course course6 = new Course();
		course6.setName("Bachelors in Technology Electrical & Electronics");
		course6.setDuration(4);
		course6.setBooks(null);
		course6.setStudents(null);

		Course course7 = new Course();
		course7.setName("Bachelors in Technology Manufacture Engg");
		course7.setDuration(4);
		course7.setBooks(null);
		course7.setStudents(null);

		course1 = courseRepository.save(course1);
		course2 = courseRepository.save(course2);
		course3 = courseRepository.save(course3);
		course4 = courseRepository.save(course4);
		course5 = courseRepository.save(course5);
		course6 = courseRepository.save(course6);
		course7 = courseRepository.save(course7);

//		Adding Address

//		Adding Students in

		Student student1 = new Student();
		student1.setFirstName("Abhishek Kumar");
		student1.setLastName("Mourya");
		student1.setEnrollmentNumber((long)12345001);
		student1.setPursuingYear(1);
		student1.setCourse(course1);
		student1.setStatus(StudentStatus.PURSUING);
		student1.setAddress(null);
		student1.setGroupMember(null);
		student1.setBorrows(null);

		Student student2 = new Student();
		student2.setFirstName("Akash");
		student2.setLastName("Kumar");
		student2.setEnrollmentNumber((long)12345002);
		student2.setPursuingYear(1);
		student2.setCourse(course1);
		student2.setStatus(StudentStatus.PURSUING);
		student2.setAddress(null);
		student2.setGroupMember(null);
		student2.setBorrows(null);

		Student student3 = new Student();
		student3.setFirstName("Mahesh");
		student3.setLastName("Raddy");
		student3.setEnrollmentNumber((long)12345003);
		student3.setPursuingYear(1);
		student3.setCourse(course2);
		student3.setStatus(StudentStatus.PURSUING);
		student3.setAddress(null);
		student3.setGroupMember(null);
		student3.setBorrows(null);

		Student student4 = new Student();
		student4.setFirstName("Ravi");
		student4.setLastName("Ranjan");
		student4.setEnrollmentNumber((long)12345004);
		student4.setPursuingYear(1);
		student4.setCourse(course3);
		student4.setStatus(StudentStatus.PURSUING);
		student4.setAddress(null);
		student4.setGroupMember(null);
		student4.setBorrows(null);

		Student student5 = new Student();
		student5.setFirstName("Sanat");
		student5.setLastName("Mishra");
		student5.setEnrollmentNumber((long)12345005);
		student5.setPursuingYear(1);
		student5.setCourse(course3);
		student5.setStatus(StudentStatus.PURSUING);
		student5.setAddress(null);
		student5.setGroupMember(null);
		student5.setBorrows(null);

		Student student6 = new Student();
		student6.setFirstName("Ankita");
		student6.setLastName("Sharma");
		student6.setEnrollmentNumber((long)12345006);
		student6.setPursuingYear(1);
		student6.setCourse(course4);
		student6.setStatus(StudentStatus.PURSUING);
		student6.setAddress(null);
		student6.setGroupMember(null);
		student6.setBorrows(null);

		Student student7 = new Student();
		student7.setFirstName("Garvita");
		student7.setLastName("Singh");
		student7.setEnrollmentNumber((long)12345007);
		student7.setPursuingYear(1);
		student7.setCourse(course1);
		student7.setStatus(StudentStatus.PURSUING);
		student7.setAddress(null);
		student7.setGroupMember(null);
		student7.setBorrows(null);

		Student student8 = new Student();
		student8.setFirstName("Parminder");
		student8.setLastName("Singh");
		student8.setEnrollmentNumber((long)12345008);
		student8.setPursuingYear(1);
		student8.setCourse(course6);
		student8.setStatus(StudentStatus.PURSUING);
		student8.setAddress(null);
		student8.setGroupMember(null);
		student8.setBorrows(null);

		Student student9 = new Student();
		student9.setFirstName("Shashi");
		student9.setLastName("Kala");
		student9.setEnrollmentNumber((long)12345009);
		student9.setPursuingYear(1);
		student9.setCourse(course6);
		student9.setStatus(StudentStatus.PURSUING);
		student9.setAddress(null);
		student9.setGroupMember(null);
		student9.setBorrows(null);

		Student student10 = new Student();
		student10.setFirstName("Aditya");
		student10.setLastName("Verma");
		student10.setEnrollmentNumber((long)12345010);
		student10.setPursuingYear(1);
		student10.setCourse(course7);
		student10.setStatus(StudentStatus.PURSUING);
		student10.setAddress(null);
		student10.setGroupMember(null);
		student10.setBorrows(null);


		Student savedStudent1 = studentRepository.save(student1);
		Student savedStudent2 = studentRepository.save(student2);
		Student savedStudent3 = studentRepository.save(student3);
		Student savedStudent4 = studentRepository.save(student4);
		Student savedStudent5 = studentRepository.save(student5);
		Student savedStudent6 = studentRepository.save(student6);
		Student savedStudent7 = studentRepository.save(student7);
		Student savedStudent8 = studentRepository.save(student8);
		Student savedStudent9 = studentRepository.save(student9);
		Student savedStudent10 = studentRepository.save(student10);

		course1.addStudent(student1);
		course1.addStudent(student2);
		course2.addStudent(student3);
		course3.addStudent(student4);
		course3.addStudent(student5);
		course4.addStudent(student6);
		course4.addStudent(student7);
		course6.addStudent(student8);
		course6.addStudent(student9);
		course7.addStudent(student10);

		course1 = courseRepository.save(course1);
		course2 = courseRepository.save(course2);
		course3 = courseRepository.save(course3);
		course4 = courseRepository.save(course4);
		course6 = courseRepository.save(course6);
		course7 = courseRepository.save(course7);*/



//	}
}





