package com.example.pack.group;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GroupService {

        private final GroupRepository groupRepository;
        private final GroupMapper groupMapper;

        public GroupService(GroupRepository groupRepository, GroupMapper groupMapper) {
                this.groupRepository = groupRepository;
                this.groupMapper = groupMapper;
        }

        public List<GroupDto> getGroupList(){
                return groupRepository.findAll()
                        .stream()
                        .map(groupMapper::toGroupDto)
                        .toList();
        }

        public void createGroup(GroupDto dto){
                GroupJpaEntity entity = groupMapper.toEntity(dto);
                groupRepository.save(entity);
        }



}
