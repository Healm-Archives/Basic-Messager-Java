package com.example.pack.group;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pack.global.GlobalResponseDto;
import com.example.pack.user.UserInfoDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;




@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class GroupController {

        private final GroupService groupService;
        
        @PostMapping("/group/create")
        public ResponseEntity<GlobalResponseDto> createGroup(@Valid @RequestBody GroupCreateDto dto) {
                return groupService.createGroup(dto);
        }
        
        @PostMapping("/group/join/{groupUuid}")
        public ResponseEntity<GlobalResponseDto> joinGroup(
                @RequestBody UserInfoDto userDto,
                @PathVariable("groupUuid") UUID groupUuid
        ) {
                return groupService.joinGroup(groupUuid, userDto);
        }

        @PostMapping("/group/leave/{groupUuid}")
        public ResponseEntity<GlobalResponseDto> leaveGroup(
                @RequestBody UserInfoDto userDto,
                @PathVariable("groupUuid") UUID groupUuid
        ) {
                return groupService.leaveGroup(groupUuid, userDto);
        }

        @PostMapping("/group/edit")
        public ResponseEntity<GlobalResponseDto> editGroup(
                @RequestBody GroupEditDto groupEditDto
        ) {
                return groupService.editGroup(groupEditDto);
        }
        

        @GetMapping("/groups/{userUuid}")
        public ResponseEntity<GroupListDto> getUserGroups(
                @PathVariable("userUuid") UUID userUuid
        ) {
                return groupService.getGroupListByUser(userUuid);
        }

        @GetMapping("/groups/search")
        public ResponseEntity<GroupListDto> getUserGroups(
                @RequestParam("groupName") String groupName
        ) {
                return groupService.getGroupListByName(groupName);
        }
        
        @GetMapping("/group/{groupUuid}/members")
        public ResponseEntity<GroupMemberDto> getMethodName(
                @PathVariable("groupUuid") UUID groupUuid
        ) {
            return groupService.getGroupMembers(groupUuid);
        }
        

}
