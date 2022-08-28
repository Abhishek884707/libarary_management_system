package com.mindtree.library_management_system.repository;

import com.mindtree.library_management_system.model.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<Fine, Integer> {
}
