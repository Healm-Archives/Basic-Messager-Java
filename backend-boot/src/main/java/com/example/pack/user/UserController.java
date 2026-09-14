package com.example.pack.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


// @CrossOrigin("*")
@RequestMapping(path = "/api/v1")
@RestController
@RequiredArgsConstructor
public class UserController {
        // private final UserService userService;
        
        // @GetMapping("/user")
        // public UserJpaEntity getUser(
        //         @RequestParam("userUuid") UUID userUuid
        // ) {
        //         return userService.getUserById(userUuid);
        // }
        
        // @GetMapping("/user/{user-uuid}")
        // public UserDto getUserNameById(
        //         @PathVariable("user-uuid") UUID userUuid
        // ) {
        //         return userService.getUserNameById(userUuid);
        // }
        
        // @GetMapping("/users")
        // public List<UserDto> getUsers() {
        //         return userService.getAllUserDto();
        // }
        
        // @GetMapping("/users/{name}")
        // public List<UserDto> getUsersContaining(
        //         @PathVariable("name") String name
        // ) {
        //     return userService.getUsersContaining(name);
        // }
        


}
