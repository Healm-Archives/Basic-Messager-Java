package com.example.pack.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


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
        public User getUser(
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
        
        
}
