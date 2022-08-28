package com.mindtree.library_management_system.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.library_management_system.enums.GroupStatus;
import com.mindtree.library_management_system.model.Student;

import javax.persistence.*;
import java.util.List;
public class GroupNameDto {

    private int Id;

    private String GroupName;

    private GroupStatus groupStatus;

    private List<Student> students;

    public GroupNameDto() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public GroupStatus getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(GroupStatus groupStatus) {
        this.groupStatus = groupStatus;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
