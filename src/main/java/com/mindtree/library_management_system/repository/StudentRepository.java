package com.mindtree.library_management_system.repository;

import com.mindtree.library_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE LOWER(s.firstName) LIKE LOWER(CONCAT('%',CONCAT(:firstName,'%'))) OR LOWER(s.lastName) LIKE LOWER(CONCAT('%',CONCAT(:lastName,'%')))")
    Optional<List<Student>> findByFirstNameOrLastName(@Param("firstName") String firstname,@Param("lastName") String lastName);

}
