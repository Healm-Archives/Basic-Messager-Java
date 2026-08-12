package com.example.pack.group;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pack.global.GlobalResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class GroupController {

        private final GroupService groupService;
        
        @GetMapping("/groups")
        public List<GroupDto> getGroupList(
                
        ) {
                return groupService.getGroupList();
        }
        
        @PostMapping("/group")
        public ResponseEntity<GlobalResponseDto> createGroup(@Valid @RequestBody GroupDto dto) {
                groupService.createGroup(dto);
                return ResponseEntity.ok(new GlobalResponseDto(List.of("Group Created Successfully")));
        }
        

}
