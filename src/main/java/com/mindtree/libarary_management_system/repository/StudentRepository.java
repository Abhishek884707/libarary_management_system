package com.mindtree.libarary_management_system.repository;

import com.mindtree.libarary_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
