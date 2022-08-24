package com.mindtree.libarary_management_system.utilities;

import com.mindtree.libarary_management_system.dto.GroupMemberDto;
import com.mindtree.libarary_management_system.dto.GroupNameDto;
import com.mindtree.libarary_management_system.model.GroupMember;
import com.mindtree.libarary_management_system.model.GroupName;

public class GroupUtility {

    public static GroupNameDto fromGroupNameToGroupNameDto(GroupName groupName){

        GroupNameDto groupNameDto = new GroupNameDto();

        groupNameDto.setId(groupName.getId());
        groupNameDto.setGroupName(groupName.getGroupName());
        groupNameDto.setGroupStatus(groupName.getGroupStatus());
        groupNameDto.setGroupMember(groupName.getGroupMember());

        return groupNameDto;
    }

    public static GroupName fromGroupNameDtoToGroupName(GroupNameDto groupNameDto){

        GroupName groupName = new GroupName();

        groupName.setId(groupNameDto.getId());
        groupName.setGroupName(groupNameDto.getGroupName());
        groupName.setGroupStatus(groupNameDto.getGroupStatus());
        groupName.setGroupMember(groupNameDto.getGroupMember());

        return groupName;
    }

    public static GroupMemberDto fromGroupMemberToGroupMemberDto(GroupMember groupMember){
        GroupMemberDto groupMemberDto = new GroupMemberDto();

        groupMemberDto.setId(groupMember.getId());
        groupMemberDto.setGroupName(groupMember.getGroupName());
        groupMemberDto.setStudent(groupMember.getStudent());

        return groupMemberDto;
    }

    public static GroupMember fromGroupMemberDtoToGroupMember(GroupMemberDto groupMemberDto){
        GroupMember groupMember = new GroupMember();

        groupMember.setId(groupMemberDto.getId());
        groupMember.setGroupName(groupMemberDto.getGroupName());
        groupMember.setStudent(groupMemberDto.getStudent());

        return groupMember;
    }

}
