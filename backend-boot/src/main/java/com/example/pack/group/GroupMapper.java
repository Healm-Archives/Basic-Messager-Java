package com.example.pack.group;

import org.springframework.stereotype.Service;

import com.example.pack.group.dto.GroupCreateDto;
import com.example.pack.group.dto.GroupInfoDto;

@Service
public class GroupMapper {
        
        public GroupInfoDto toInfoDto(GroupJpaEntity entity){
                return new GroupInfoDto(entity.getUuid(), entity.getName());
        }

        public GroupJpaEntity toEntity(GroupCreateDto dto){
                GroupJpaEntity entity = new GroupJpaEntity();
                entity.setName(dto.name());

                return entity;   
        }

}
