package com.mindtree.libarary_management_system.repository;

import com.mindtree.libarary_management_system.model.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Integer> {
}
