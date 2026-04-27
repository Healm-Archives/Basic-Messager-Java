package com.example.pack.user.mapper;

import org.springframework.stereotype.Service;

import com.example.pack.user.adapter.outbound.persistence.UserJpaEntity;
import com.example.pack.user.application.dto.UserDto;

@Service
public class UserMapper {

        public UserJpaEntity dtoToUser(UserDto dto){
                UserJpaEntity user = new UserJpaEntity();
                user.setName(dto.name());
                return user;
        }
        
        public UserDto userToDto(UserJpaEntity user){
                return new UserDto(
                        user.getName()
                );
        }

}
