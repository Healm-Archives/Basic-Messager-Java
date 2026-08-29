package com.example.pack.user;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.pack.user.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

        private final UserRepository userRepository;
        private final UserMapper userMapping;
        

        public UserJpaEntity getUserById(UUID userId){
                return userRepository.getReferenceById(userId);
        }

        public UserDto getUserNameById(UUID userId){
                UserJpaEntity user = userRepository.getReferenceById(userId);
                return userMapping.toDto(user);
        }

        public List<UserDto> getAllUserDto(){
                return userRepository
                        .findAll()
                        .stream()
                        .map(userMapping::toDto)
                        .toList();
        }

        public List<UserDto> getUsersContaining(String name){
                return userRepository
                        .findByNameStartsWith(name)
                        .stream()
                        .map(userMapping::toDto)
                        .toList();
        }

}
