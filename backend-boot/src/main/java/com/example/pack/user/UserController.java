package com.example.pack.user;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")

@RestController
public class UserController {
        private final UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @PostMapping("/api/v1/user")
        public void addUser(@RequestBody UserDto userDto) {
                userService.addUser(userDto);
        }
        
        @GetMapping("/api/v1/user")
        public UserJpaEntity getUser(
                @RequestParam("userId") Integer userId
        ) {
                return userService.getUserById(userId);
        }
        
        @GetMapping("/api/v1/user/{user-id}")
        public UserDto getUserNameById(
                @PathVariable("user-id") Integer userId
        ) {
                return userService.getUserNameById(userId);
        }
        
        @GetMapping("/api/v1/users")
        public List<UserDto> getUsers() {
                return userService.getAllUserDto();
        }
        
        @GetMapping("/api/v1/users/{name}")
        public List<UserDto> getUsersContaining(
                // @PathVariable String name
                @PathVariable("name") String name
        ) {
            return userService.getUsersContaining(name);
        }
        


}
