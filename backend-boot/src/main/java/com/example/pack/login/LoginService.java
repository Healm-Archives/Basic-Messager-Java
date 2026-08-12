package com.example.pack.login;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.pack.global.GlobalResponseDto;
import com.example.pack.security.JwtService;
import com.example.pack.user.UserJpaEntity;
import com.example.pack.user.UserMapper;
import com.example.pack.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
        
        private final UserMapper userMapper;
        private final UserRepository userRepository;

        private final AuthenticationManager authenticationManager;
        private final JwtService jwtService;

        private final PasswordEncoder passwordEncoder;

        public ResponseEntity<GlobalResponseDto> authenticateRegister(LoginUserDto userDto){
                
                UserJpaEntity user = userMapper.privateDtoToUser(userDto);
                user.setPassword(passwordEncoder.encode(user.getPassword()));

                userRepository.save(user);
                return ResponseEntity.ok(new GlobalResponseDto(List.of("Success Sign-in")));

        }

        public ResponseEntity<ResponseLoginDto> authenticateLogin(LoginUserDto dto){
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                dto.name(), 
                                dto.password()
                        )
                );

                // System.out.println("Authenticated: " + authentication.isAuthenticated());

                UserDetails user = (UserDetails) authentication.getPrincipal();
                String token = jwtService.generateToken(user);
                
                // System.out.println("Bearer " + token);
                return ResponseEntity.ok(new ResponseLoginDto(token, List.of("Successful login")));
                
        }
}
