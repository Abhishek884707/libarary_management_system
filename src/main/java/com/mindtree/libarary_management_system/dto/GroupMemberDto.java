package com.mindtree.libarary_management_system.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.libarary_management_system.model.GroupName;
import com.mindtree.libarary_management_system.model.Student;

import javax.persistence.*;

public class GroupMemberDto {
    private int Id;

    private GroupName groupName;

    private Student student;

    public GroupMemberDto() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public GroupName getGroupName() {
        return groupName;
    }

    public void setGroupName(GroupName groupName) {
        this.groupName = groupName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
