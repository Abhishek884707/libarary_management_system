package com.mindtree.libarary_management_system.repository;

import com.mindtree.libarary_management_system.model.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedRepository extends JpaRepository<Borrowed, Integer> {
}
