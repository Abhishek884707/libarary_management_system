package com.mindtree.library_management_system.utilities;

import com.mindtree.library_management_system.dto.GroupNameDto;
import com.mindtree.library_management_system.model.GroupName;

public class GroupUtility {

    public static GroupNameDto fromGroupNameToGroupNameDto(GroupName groupName){

        GroupNameDto groupNameDto = new GroupNameDto();

        groupNameDto.setId(groupName.getId());
        groupNameDto.setGroupName(groupName.getGroupName());
        groupNameDto.setGroupStatus(groupName.getGroupStatus());
        groupNameDto.setStudents(groupName.getStudents());

        return groupNameDto;
    }

    public static GroupName fromGroupNameDtoToGroupName(GroupNameDto groupNameDto){

        GroupName groupName = new GroupName();

        groupName.setId(groupNameDto.getId());
        groupName.setGroupName(groupNameDto.getGroupName());
        groupName.setGroupStatus(groupNameDto.getGroupStatus());
        groupName.setStudents(groupNameDto.getStudents());

        return groupName;
    }
}
