package com.example.pack.group;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.pack.global.GlobalResponseDto;
import com.example.pack.group.dto.GroupCreateDto;
import com.example.pack.group.dto.GroupEditDto;
import com.example.pack.group.dto.GroupInfoDto;
import com.example.pack.group.dto.GroupInfoListDto;
import com.example.pack.group.dto.GroupMemberDto;
import com.example.pack.user.UserJpaEntity;
import com.example.pack.user.UserMapper;
import com.example.pack.user.UserRepository;
import com.example.pack.user.dto.UserInfoDto;
import com.example.pack.user.dto.UserMemberDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupService {

        private final GroupRepository groupRepository;
        private final GroupMapper groupMapper;

        
        private final UserRepository userRepository;
        private final UserMapper userMapper;

        public ResponseEntity<GlobalResponseDto> createGroup(GroupCreateDto dto){
                GroupJpaEntity entity = groupMapper.toEntity(dto);
                groupRepository.save(entity);
                return ResponseEntity.ok(new GlobalResponseDto("Group Created Successfully"));
        }

        public ResponseEntity<GlobalResponseDto> joinGroup(UUID groupUuid, UserInfoDto userDto) {
                GroupJpaEntity entity = groupRepository.findById(groupUuid).orElseThrow();                
                
                List<UserJpaEntity> memberList = entity.getMemberList();
                
                UserJpaEntity currentUser = userRepository.findById(userDto.userUuid()).orElse(null);
                
                if (memberList.contains(currentUser) || currentUser == null){
                        return ResponseEntity.badRequest().body(new GlobalResponseDto("User already joined this group"));
                }
                memberList.add(currentUser);
                
                entity.setMemberList(memberList);

                groupRepository.save(entity);
                
                return ResponseEntity.ok(new GlobalResponseDto("Group Joined Successfully"));
        }
        
        public ResponseEntity<GlobalResponseDto> leaveGroup(UUID groupUuid, UserInfoDto userDto) {
                GroupJpaEntity entity = groupRepository.findById(groupUuid).orElseThrow();                
                
                List<UserJpaEntity> memberList = entity.getMemberList();
                
                UserJpaEntity currentUser = userRepository.findById(userDto.userUuid()).orElse(null);
                
                if (!memberList.contains(currentUser) || currentUser == null){
                        return ResponseEntity.badRequest().body(new GlobalResponseDto("User already left the group"));
                }
                memberList.remove(currentUser);
                
                entity.setMemberList(memberList);

                groupRepository.save(entity);
                
                return ResponseEntity.ok(new GlobalResponseDto("Group left Successfully"));
        }

        public ResponseEntity<GroupInfoListDto> getGroupListByUser(UUID userUuid) {
                List<GroupInfoDto> dto = groupRepository.findAllByMemberListUuid(userUuid)
                                                .stream()
                                                .map(groupMapper::toInfoDto)
                                                .toList();


                return ResponseEntity.ok(new GroupInfoListDto(dto));

        }

        public ResponseEntity<GroupInfoListDto> getGroupListByName(String groupName) {
                List<GroupInfoDto> dto = groupRepository.findAllByNameStartsWith(groupName)
                                                .stream()
                                                .map(groupMapper::toInfoDto)
                                                .toList();

                return ResponseEntity.ok(new GroupInfoListDto(dto));

        }

        public ResponseEntity<GlobalResponseDto> editGroup(GroupEditDto groupEditDto) {
                GroupJpaEntity entity = groupRepository.findById(groupEditDto.groupUuid()).orElseThrow();
                entity.setName(groupEditDto.groupName());
                entity.setDescription(groupEditDto.description());

                groupRepository.save(entity);

                return ResponseEntity.ok(new GlobalResponseDto("Successfully applied changes"));
        }

        public ResponseEntity<GroupMemberDto> getGroupMembers(UUID groupUuid) {
                GroupJpaEntity entity = groupRepository.findById(groupUuid).orElseThrow();

                List<UserMemberDto> memberList = entity.getMemberList()
                        .stream()
                        .map(userMapper::toMemberDto)
                        .toList();

                return ResponseEntity.ok(new GroupMemberDto(memberList));
        }



}
