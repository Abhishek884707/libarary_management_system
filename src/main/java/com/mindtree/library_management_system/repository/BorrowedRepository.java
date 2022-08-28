package com.mindtree.library_management_system.repository;

import com.mindtree.library_management_system.model.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BorrowedRepository extends JpaRepository<Borrowed, Integer> {


    @Query("SELECT b FROM Borrowed b WHERE (LOWER(b.book.name) LIKE LOWER(CONCAT('%',CONCAT(:bookName,'%')))) OR (LOWER(b.student.firstName) LIKE LOWER(CONCAT('%',CONCAT(:firstName,'%'))) OR LOWER(b.student.lastName) LIKE LOWER(CONCAT('%',CONCAT(:lastName,'%'))))")
    Optional<List<Borrowed>> findBorrowed(@Param("bookName") String bookName,@Param("firstName") String firstName,@Param("lastName") String lastName);
}
