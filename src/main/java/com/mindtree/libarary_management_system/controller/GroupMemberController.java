package com.mindtree.libarary_management_system.controller;

import com.mindtree.libarary_management_system.dto.GroupMemberDto;
import com.mindtree.libarary_management_system.model.Address;
import com.mindtree.libarary_management_system.model.GroupMember;
import com.mindtree.libarary_management_system.service.GroupService;
import com.mindtree.libarary_management_system.utilities.GroupUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("library_management_system/v1/")
@CrossOrigin("*")
public class GroupMemberController {


    @Autowired
    GroupService groupService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/group_member/{groupMemberId}")
    public GroupMemberDto getGroupMemberById(@PathVariable("groupMemberId") int id){
        log.info("{}",id);
        GroupMemberDto groupMemberDto = GroupUtility.fromGroupMemberToGroupMemberDto(groupService.getGroupMemberById(id).get());
        return groupMemberDto;
    }

    @PostMapping("/group_member")
    public GroupMemberDto createNewGroupMember(@RequestBody GroupMemberDto groupMemberDto){
        log.info("{}", groupMemberDto);
        GroupMember groupMember = GroupUtility.fromGroupMemberDtoToGroupMember(groupMemberDto);
        groupMemberDto = GroupUtility.fromGroupMemberToGroupMemberDto(groupService.addNewGroupMember(groupMember));
        return groupMemberDto;
    }

    @PutMapping("/group_member")
    public GroupMemberDto editGroupMember(@RequestBody GroupMemberDto groupMemberDto){
        log.info("{}", groupMemberDto);
        GroupMember groupMember = GroupUtility.fromGroupMemberDtoToGroupMember(groupMemberDto);
        groupMemberDto = GroupUtility.fromGroupMemberToGroupMemberDto(groupService.updateGroupMember(groupMember));
        return groupMemberDto;
    }

    @DeleteMapping("/group_member")
    public boolean removeGroupMember(@RequestBody GroupMemberDto groupMemberDto){
        log.info("{}", groupMemberDto);
        log.info("{}", groupMemberDto);
        GroupMember groupMember = GroupUtility.fromGroupMemberDtoToGroupMember(groupMemberDto);
        return groupService.deleteGroupMember(groupMember);
    }
}
