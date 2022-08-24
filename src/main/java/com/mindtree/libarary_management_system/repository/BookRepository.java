package com.mindtree.libarary_management_system.repository;

import com.mindtree.libarary_management_system.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
