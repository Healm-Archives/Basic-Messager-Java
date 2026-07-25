package com.example.pack.user;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

        private final UserRepository userRepository;
        private final UserMapper userMapping;
        
        public void registerUser(PrivateUserDto userDto){
                UserJpaEntity user = userMapping.privateDtoToUser(userDto);
                userRepository.save(user);
        }

        public UserJpaEntity getUserById(UUID userId){
                return userRepository.getReferenceById(userId);
        }

        public UserDto getUserNameById(UUID userId){
                UserJpaEntity user = userRepository.getReferenceById(userId);
                return userMapping.userToDto(user);
        }

        public List<UserDto> getAllUserDto(){
                return userRepository
                        .findAll()
                        .stream()
                        .map(userMapping::userToDto)
                        .toList();
        }

        public List<UserDto> getUsersContaining(String name){
                return userRepository
                        // .findAllByNameStartsWith(name)
                        .findByNameStartsWith(name)
                        .stream()
                        .map(userMapping::userToDto)
                        .toList();
        }
}
