package com.example.pack.group;

import org.springframework.stereotype.Service;

@Service
public class GroupMapper {
        
        public GroupDto toGroupDto(GroupJpaEntity entity){
                return new GroupDto(entity.getName());
        }

        public GroupJpaEntity toEntity(GroupDto dto){
                GroupJpaEntity entity = new GroupJpaEntity();
                entity.setName(dto.name());

                return entity;   
        }
}
