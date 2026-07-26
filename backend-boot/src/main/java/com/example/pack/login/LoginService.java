package com.example.pack.login;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        public ResponseEntity<String> authenticateRegister(PrivateUserDto userDto){
                try {
                        UserJpaEntity user = userMapper.privateDtoToUser(userDto);
                        userRepository.save(user);
                        return new ResponseEntity<>("Success Sign-in", HttpStatus.OK);
                        
                } catch (DataIntegrityViolationException e) {
                        // System.out.println("Duplicate keys");
                        return new ResponseEntity<>("Name already existed", HttpStatus.UNAUTHORIZED);
                }

        }

        public ResponseEntity<String> authenticateLogin(PrivateUserDto dto){
        
                UserJpaEntity user = userRepository.findByName(dto.name()).orElse(null);

                // System.out.println("User : "+ user);

                if (user == null){
                        // System.out.println("User not found");
                        return new ResponseEntity<String>("User does not exist", HttpStatus.UNAUTHORIZED);
                }
                
                // if (Objects.equals(dto.password(), user.getPassword())){
                if (!dto.password().equals(user.getPassword())){
                        // System.out.println("Password dont match");
                        return new ResponseEntity<String>("Password did not match", HttpStatus.UNAUTHORIZED);
                }

                // System.out.println("Logging in...");
                return new ResponseEntity<String>("Successful login", HttpStatus.OK);
                
        }
}
