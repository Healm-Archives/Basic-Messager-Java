package com.example.pack.user.adapter.inbound.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pack.user.adapter.outbound.persistence.UserJpaEntity;
import com.example.pack.user.application.dto.UserDto;
import com.example.pack.user.application.service.UserService;


@RestController
public class UserController {
        private final UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @PostMapping("/user")
        public void addUser(@RequestBody UserDto userDto) {
                userService.addUser(userDto);
        }
        
        @GetMapping("/user")
        public UserJpaEntity getUser(
                @RequestParam("userId") Integer userId
        ) {
                return userService.getUserById(userId);
        }
        
        @GetMapping("/user/{user-id}")
        public UserDto getUserNameById(
                @PathVariable("user-id") Integer userId
        ) {
                return userService.getUserNameById(userId);
        }
        
        @GetMapping("/users")
        public List<UserDto> getUsers() {
                return userService.getAllUserDto();
        }
        
        @GetMapping("/users/{name}")
        public List<UserDto> getUsersContaining(@PathVariable String name) {
            return userService.getUsersContaining(name);
        }
        


}
