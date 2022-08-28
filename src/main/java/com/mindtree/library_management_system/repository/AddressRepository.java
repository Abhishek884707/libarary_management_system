package com.mindtree.library_management_system.repository;

import com.mindtree.library_management_system.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
