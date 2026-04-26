package com.example.pack.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
        private final UserRepository userRepository;
        private final UserMapping userMapping;

        public UserService(UserRepository userRepository, UserMapping userMapping) {
                this.userRepository = userRepository;
                this.userMapping = userMapping;
        }

        public void addUser(UserDto userDto){
                User user = userMapping.dtoToUser(userDto);
                userRepository.save(user);
        }

        public User getUserById(Integer userId){
                return userRepository.getReferenceById(userId);
        }

        public UserDto getUserNameById(Integer userId){
                User user = userRepository.getReferenceById(userId);
                return userMapping.userToDto(user);
        }

}
