package com.mindtree.libarary_management_system.repository;

import com.mindtree.libarary_management_system.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}
