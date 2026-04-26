package com.example.pack.user;

import org.springframework.stereotype.Service;

@Service
public class UserMapper {

        public User dtoToUser(UserDto dto){
                User user = new User();
                user.setName(dto.name());
                return user;
        }
        
        public UserDto userToDto(User user){
                return new UserDto(
                        user.getName()
                );
        }
}
