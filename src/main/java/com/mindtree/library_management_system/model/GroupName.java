package com.mindtree.library_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.library_management_system.enums.GroupStatus;

import javax.persistence.*;
import java.util.List;
@Entity
public class GroupName {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String GroupName;

    private GroupStatus groupStatus;

//    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "groupName")
    private List<Student> students;

    public GroupName() {
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

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    public void setStudents(List<Student> studetns) {
        this.students = studetns;
    }
}
