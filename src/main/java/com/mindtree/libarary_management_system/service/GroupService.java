package com.mindtree.libarary_management_system.service;

import com.mindtree.libarary_management_system.model.GroupMember;
import com.mindtree.libarary_management_system.model.GroupName;
import com.mindtree.libarary_management_system.model.Student;
import com.mindtree.libarary_management_system.repository.GroupMemberRepository;
import com.mindtree.libarary_management_system.repository.GroupNameRepository;
import com.mindtree.libarary_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    GroupMemberRepository groupMemberRepository;

    @Autowired
    GroupNameRepository groupNameRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<GroupMember> getAllGroupMember(){
        return groupMemberRepository.findAll();
    }

    public Optional<GroupMember> getGroupMemberById(int id) {
        return groupMemberRepository.findById(id);
    }

    public GroupMember addNewGroupMember(GroupMember groupMember) {
        Optional<GroupName> optionalGroupName = this.getGroupNameById(groupMember.getGroupName().getId());
        if(optionalGroupName.isPresent()){
            groupMember.setGroupName(optionalGroupName.get());
        }

        Optional<Student> optionalStudent = studentRepository.findById(groupMember.getStudent().getId());
        if(optionalStudent.isPresent()){
            groupMember.setStudent(optionalStudent.get());
        }
        groupMember = groupMemberRepository.save(groupMember);

        optionalStudent.get().setGroupMember(groupMember);
        studentRepository.save(optionalStudent.get());

        optionalGroupName.get().addGroupMember(groupMember);
        this.groupNameRepository.save(optionalGroupName.get());

        return groupMember;
    }


    public GroupMember updateGroupMember(GroupMember groupMember) {

        Optional<GroupMember> optionalGroupMember = this.getGroupMemberById(groupMember.getId());
        if(optionalGroupMember.isPresent()){
            Optional<GroupName> optionalGroupName = this.getGroupNameById(optionalGroupMember.get().getGroupName().getId());
            GroupName groupName;
            if(groupMember.getGroupName().getId() != optionalGroupName.get().getId() && optionalGroupName.get().getGroupMember().size() < 6) {
                optionalGroupName.get().removeGroupMember(optionalGroupMember.get());
                groupName = groupNameRepository.save(optionalGroupName.get());
                optionalGroupName = this.getGroupNameById(groupMember.getGroupName().getId());
                optionalGroupName.get().addGroupMember(optionalGroupMember.get());
                groupName = groupNameRepository.save(optionalGroupName.get());
                optionalGroupMember.get().setGroupName(groupName);
            }
        }

        groupMember = groupMemberRepository.save(optionalGroupMember.get());

        return groupMember;

    }


    public boolean deleteGroupMember(GroupMember groupMember) {

        if(this.getGroupMemberById(groupMember.getId()).isPresent()){
            groupMemberRepository.delete(groupMember);
            return true;
        }
        return false;

    }

    public List<GroupName> getAllGroupName(){
        return groupNameRepository.findAll();
    }

    public Optional<GroupName> getGroupNameById(int id) {
        return groupNameRepository.findById(id);
    }

    public GroupName addNewGroupName(GroupName groupName) {
        return groupNameRepository.save(groupName);
    }

    public GroupName updateGroupName(GroupName groupName) {
        Optional<GroupName> optionalGroupName = this.getGroupNameById(groupName.getId());
        if(optionalGroupName.isPresent()){
            optionalGroupName.get().setGroupName(groupName.getGroupName());
            optionalGroupName.get().setGroupStatus(groupName.getGroupStatus());
        }
        return groupNameRepository.save(optionalGroupName.get());
    }

    public boolean deleteGroupName(GroupName groupName) {
        if(this.getGroupNameById(groupName.getId()).isPresent()){
            groupNameRepository.delete(groupName);
            return true;
        }
        return false;
    }
}
