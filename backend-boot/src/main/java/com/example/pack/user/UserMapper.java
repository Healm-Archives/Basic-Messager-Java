package com.example.pack.user;

import org.springframework.stereotype.Service;

import com.example.pack.login.LoginUserDto;

@Service
public class UserMapper {

        public UserJpaEntity toUser(UserDto dto){
                UserJpaEntity user = new UserJpaEntity();
                user.setName(dto.name());
                return user;
        }

        public UserJpaEntity toUser(LoginUserDto dto){
                UserJpaEntity user = new UserJpaEntity();
                user.setName(dto.name());
                user.setPassword(dto.password());
                return user;
        }
        
        public UserJpaEntity toUser(UserInfoDto dto){
                UserJpaEntity user = new UserJpaEntity();
                user.setUuid(dto.userUuid());
                return user;
        }

        public UserDto toDto(UserJpaEntity user){
                return new UserDto(
                        user.getName()
                );
        }

}
