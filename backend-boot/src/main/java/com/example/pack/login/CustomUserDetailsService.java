package com.example.pack.login;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.pack.user.UserJpaEntity;
import com.example.pack.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
        
        private final UserRepository userRepository;
        
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
        {
                UserJpaEntity user = userRepository
                        .findByName(username)
                        .orElseThrow(() -> new UsernameNotFoundException(username));

                return User
                        .withUsername(username)
                        .password(user.getPassword())
                        .build()
                        ;
        }
}