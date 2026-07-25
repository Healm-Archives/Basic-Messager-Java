package com.example.pack.user;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")

@RequestMapping(path = "/api/v1")
@RestController
public class UserController {
        private final UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        // @PostMapping("/user")
        // public void addUser(@RequestBody PrivateUserDto userDto) {
        //         userService.registerUser(userDto);
        // }
        
        @GetMapping("/user")
        public UserJpaEntity getUser(
                @RequestParam("userUuid") UUID userUuid
        ) {
                return userService.getUserById(userUuid);
        }
        
        @GetMapping("/user/{user-uuid}")
        public UserDto getUserNameById(
                @PathVariable("user-uuid") UUID userUuid
        ) {
                return userService.getUserNameById(userUuid);
        }
        
        @GetMapping("/users")
        public List<UserDto> getUsers() {
                return userService.getAllUserDto();
        }
        
        @GetMapping("/users/{name}")
        public List<UserDto> getUsersContaining(
                @PathVariable("name") String name
        ) {
            return userService.getUsersContaining(name);
        }
        


}
