package com.example.pack.group;

import com.example.pack.login.LoginController;
import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.pack.global.GlobalResponseDto;
import com.example.pack.user.UserInfoDto;
import com.example.pack.user.UserJpaEntity;
import com.example.pack.user.UserMapper;
import com.example.pack.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupService {

        private final GroupRepository groupRepository;
        private final GroupMapper groupMapper;

        
        private final UserRepository userRepository;

        public List<GroupInfoDto> getGroupList(){
                return groupRepository.findAll()
                        .stream()
                        .map(groupMapper::toInfoDto)
                        .toList();
        }

        public ResponseEntity<GlobalResponseDto> createGroup(GroupCreateDto dto){
                GroupJpaEntity entity = groupMapper.toEntity(dto);
                groupRepository.save(entity);
                return ResponseEntity.ok(new GlobalResponseDto(List.of("Group Created Successfully")));
        }

        public ResponseEntity<GlobalResponseDto> joinGroup(UUID groupUuid, UserInfoDto userDto) {
                GroupJpaEntity entity = groupRepository.findById(groupUuid).orElseThrow();                
                
                List<UserJpaEntity> memberList = entity.getMemberList();
                
                UserJpaEntity currentUser = userRepository.findById(userDto.userUuid()).orElse(null);
                
                if (memberList.contains(currentUser) || currentUser == null){
                        return ResponseEntity.badRequest().body(new GlobalResponseDto(List.of("User already joined this group")));
                }
                memberList.add(currentUser);
                
                entity.setMemberList(memberList);

                groupRepository.save(entity);
                
                return ResponseEntity.ok(new GlobalResponseDto(List.of("Group Joined Successfully")));
        }
        
        public ResponseEntity<GlobalResponseDto> leaveGroup(UUID groupUuid, UserInfoDto userDto) {
                GroupJpaEntity entity = groupRepository.findById(groupUuid).orElseThrow();                
                
                List<UserJpaEntity> memberList = entity.getMemberList();
                
                UserJpaEntity currentUser = userRepository.findById(userDto.userUuid()).orElse(null);
                
                if (!memberList.contains(currentUser) || currentUser == null){
                        return ResponseEntity.badRequest().body(new GlobalResponseDto(List.of("User already left the group")));
                }
                memberList.remove(currentUser);
                
                entity.setMemberList(memberList);

                groupRepository.save(entity);
                
                return ResponseEntity.ok(new GlobalResponseDto(List.of("Group left Successfully")));
        }

        public ResponseEntity<GroupListDto> getGroupListByUser(UUID userUuid) {
                List<GroupInfoDto> dto = groupRepository.findAllByMemberListUuid(userUuid)
                                                .stream()
                                                .map(groupMapper::toInfoDto)
                                                .toList();


                return ResponseEntity.ok(new GroupListDto(dto));

        }

        public ResponseEntity<GroupListDto> getGroupListByName(String groupName) {
                List<GroupInfoDto> dto = groupRepository.findAllByNameStartsWith(groupName)
                                                .stream()
                                                .map(groupMapper::toInfoDto)
                                                .toList();

                return ResponseEntity.ok(new GroupListDto(dto));

        }

        public ResponseEntity<GlobalResponseDto> editGroup(GroupEditDto groupEditDto) {
                GroupJpaEntity entity = groupRepository.findById(groupEditDto.groupUuid()).orElseThrow();
                entity.setName(groupEditDto.groupName());
                entity.setDescription(groupEditDto.description());

                groupRepository.save(entity);

                return ResponseEntity.ok(new GlobalResponseDto(List.of("Successfully applied changes")));
        }



}
