package com.mindtree.library_management_system.repository;

import com.mindtree.library_management_system.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}
