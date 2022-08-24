package com.mindtree.libarary_management_system.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.libarary_management_system.enums.GroupStatus;
import com.mindtree.libarary_management_system.model.GroupMember;

import java.util.List;

public class GroupNameDto {

    private int Id;

    private String GroupName;

    private GroupStatus groupStatus;

    private List<GroupMember> groupMember;

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

    public List<GroupMember> getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(List<GroupMember> groupMember) {
        this.groupMember = groupMember;
    }
}

