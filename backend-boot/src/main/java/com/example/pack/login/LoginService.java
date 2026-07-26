package com.example.pack.login;

import org.springframework.stereotype.Service;

import com.example.pack.user.PrivateUserDto;
import com.example.pack.user.UserJpaEntity;
import com.example.pack.user.UserMapper;
import com.example.pack.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
        
        private final UserMapper userMapper;
        private final UserRepository userRepository;

        public void registerUser(PrivateUserDto userDto){
                UserJpaEntity user = userMapper.privateDtoToUser(userDto);
                userRepository.save(user);
        }

        public void authenticateLogin(PrivateUserDto dto){
        
                UserJpaEntity user = userRepository.findByName(dto.name()).orElse(null);

                System.out.println("User : "+ user);

                if (user == null){
                        System.out.println("User not found");
                        return;
                }
                
                // if (Objects.equals(dto.password(), user.getPassword())){
                if (!dto.password().equals(user.getPassword())){
                        System.out.println("Password dont match");
                        return;
                }
                System.out.println("Logging in...");
        }
}
