package com.example.pack.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.pack.security.JwtService;
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

        private final AuthenticationManager authenticationManager;
        private final JwtService jwtService;

        private final PasswordEncoder passwordEncoder;

        public ResponseEntity<String> authenticateRegister(PrivateUserDto userDto){
                
                UserJpaEntity user = userMapper.privateDtoToUser(userDto);
                user.setPassword(passwordEncoder.encode(user.getPassword()));

                userRepository.save(user);
                return new ResponseEntity<>("Success Sign-in", HttpStatus.OK);

        }

        // public ResponseEntity<String> authenticateLogin(PrivateUserDto dto){
        public ResponseEntity<LoginResponseDto> authenticateLogin(PrivateUserDto dto){
                try {
                        Authentication authentication = authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                        dto.name(), 
                                        dto.password()
                                )
                        );
        
                        // System.out.println("Authenticated: " + authentication.isAuthenticated());

                        UserDetails user = (UserDetails) authentication.getPrincipal();
                        String token = jwtService.generateToken(user);
                        
                        System.out.println("Bearer " + token);
                        // return ResponseEntity.ok("Successful login");
                        return ResponseEntity.ok(new LoginResponseDto(token, "Successful login"));
                }
                catch (AuthenticationException e){
                        // System.out.println("Error : " + e.getMessage());
                        return ResponseEntity
                                .status(HttpStatus.UNAUTHORIZED)
                                .body(new LoginResponseDto("", "Bad Credential"));
                        // return new ResponseEntity<String>("Bad Credential", HttpStatus.UNAUTHORIZED);
                }
                
        }
}
