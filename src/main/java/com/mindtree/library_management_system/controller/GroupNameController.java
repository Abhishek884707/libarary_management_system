package com.mindtree.library_management_system.controller;

import com.mindtree.library_management_system.dto.GroupNameDto;
import com.mindtree.library_management_system.model.GroupName;
import com.mindtree.library_management_system.service.GroupService;
import com.mindtree.library_management_system.utilities.GroupUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("library_management_system/v1/")
@CrossOrigin("*")
public class GroupNameController {

    @Autowired
    GroupService groupService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/group_name")
    public List<GroupNameDto> retrieveAllGroupName(){
        List<GroupNameDto> groupNameDtoList = groupService.getAllGroupName().stream().map(groupName -> GroupUtility.fromGroupNameToGroupNameDto(groupName)).collect(Collectors.toList());
        return groupNameDtoList;
    }

    @GetMapping("/group_name/{groupNameId}")
    public GroupNameDto getGroupNameById(@PathVariable("groupNameId") int id){
        log.info("{}",id);
        GroupNameDto groupNameDto = GroupUtility.fromGroupNameToGroupNameDto(groupService.getGroupNameById(id).get());
        return groupNameDto;
    }

    @PostMapping("/group_name")
    public GroupNameDto createNewGroupName(@RequestBody GroupNameDto groupNameDto){
        log.info("{}", groupNameDto);
        GroupName groupName = GroupUtility.fromGroupNameDtoToGroupName(groupNameDto);
        groupNameDto = GroupUtility.fromGroupNameToGroupNameDto(groupService.addNewGroupName(groupName));
        return groupNameDto;
    }

    @PutMapping("/group_name")
    public GroupNameDto editGroupName(@RequestBody GroupNameDto groupNameDto){
        log.info("{}", groupNameDto);
        GroupName groupName = GroupUtility.fromGroupNameDtoToGroupName(groupNameDto);
        groupNameDto = GroupUtility.fromGroupNameToGroupNameDto(groupService.updateGroupName(groupName));
        return groupNameDto;
    }

    @DeleteMapping("/group_name")
    public boolean removeGroupName(@RequestBody GroupNameDto groupNameDto){
        log.info("{}", groupNameDto);
        GroupName groupName = GroupUtility.fromGroupNameDtoToGroupName(groupNameDto);
        return groupService.deleteGroupName(groupName);
    }

}
