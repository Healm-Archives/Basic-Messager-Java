package com.example.pack.user;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
        private final UserRepository userRepository;
        private final UserMapper userMapping;

        public void addUser(UserDto userDto){
                UserJpaEntity user = userMapping.dtoToUser(userDto);
                userRepository.save(user);
        }

        public UserJpaEntity getUserById(Integer userId){
                return userRepository.getReferenceById(userId);
        }

        public UserDto getUserNameById(Integer userId){
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
