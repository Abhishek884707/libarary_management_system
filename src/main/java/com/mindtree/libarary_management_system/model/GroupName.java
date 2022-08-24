package com.mindtree.libarary_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.libarary_management_system.enums.GroupStatus;
import com.mindtree.libarary_management_system.repository.GroupMemberRepository;

import javax.persistence.*;
import java.util.List;
@Entity
public class GroupName {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String GroupName;

    private GroupStatus groupStatus;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "groupName")
    private List<GroupMember> groupMembers;

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

    public List<GroupMember> getGroupMember() {
        return groupMembers;
    }

    public void addGroupMember(GroupMember groupMember) {
        this.groupMembers.add(groupMember);
    }

    public void removeGroupMember(GroupMember groupMember){
        this.groupMembers.remove(groupMember);
    }

    public void setGroupMember(List<GroupMember> groupMember) {
        this.groupMembers = groupMember;
    }
}
