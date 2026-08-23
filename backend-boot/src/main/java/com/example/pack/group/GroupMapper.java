package com.example.pack.group;

import org.springframework.stereotype.Service;

@Service
public class GroupMapper {
        
        public GroupCreateDto toGroupDto(GroupJpaEntity entity){
                return new GroupCreateDto(entity.getName());
        }

        public GroupInfoDto toInfoDto(GroupJpaEntity entity){
                return new GroupInfoDto(entity.getUuid(), entity.getName());
        }

        public GroupJpaEntity toEntity(GroupCreateDto dto){
                GroupJpaEntity entity = new GroupJpaEntity();
                entity.setName(dto.name());

                return entity;   
        }

}
