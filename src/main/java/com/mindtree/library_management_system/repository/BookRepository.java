package com.mindtree.library_management_system.repository;

import com.mindtree.library_management_system.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

//    @Query("SELECT b from Book b WHERE b.name LIKE %:name%")
    Optional<List<Book>> findByNameContainingIgnoreCase(@Param("name") String name);

}
