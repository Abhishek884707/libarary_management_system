package com.mindtree.library_management_system.service;

import com.mindtree.library_management_system.model.GroupName;
import com.mindtree.library_management_system.model.Student;
import com.mindtree.library_management_system.repository.GroupNameRepository;
import com.mindtree.library_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupService {

    @Autowired
    GroupNameRepository groupNameRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<GroupName> getAllGroupName(){
        return groupNameRepository.findAll();
    }

    public Optional<GroupName> getGroupNameById(int id) {
        return groupNameRepository.findById(id);
    }

    public GroupName addNewGroupName(GroupName groupName) {
        List<Student> savedStudents = groupName.getStudents().stream().map(student -> studentRepository.findById(student.getId()).get()).collect(Collectors.toList());

        groupName.setStudents(savedStudents);
//        groupName =  groupNameRepository.save(groupName);
        for(Student student : savedStudents){
            student.setGroupName(groupName);
        }

        return groupNameRepository.save(groupName);
    }

    public GroupName updateGroupName(GroupName groupName) {
        Optional<GroupName> optionalGroupName = this.getGroupNameById(groupName.getId());
        if(optionalGroupName.isPresent()){
            for(Student student : groupName.getStudents()){
                Optional<Student> optionalStudent = studentRepository.findById(student.getId());
                if(optionalStudent.isPresent()){
                    optionalStudent.get().setGroupName(optionalGroupName.get());
                    student = studentRepository.save(optionalStudent.get());
                    optionalGroupName.get().addStudent(student);
                }
            }
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
