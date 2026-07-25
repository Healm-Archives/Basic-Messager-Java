package com.example.pack.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pack.user.PrivateUserDto;
import com.example.pack.user.UserRepository;
import com.example.pack.user.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping(path = "/req")
public class LoginController {

        private final UserService userService;


        public LoginController(UserService userService) {
                this.userService = userService;
        }

        @GetMapping("/login")
        public String login() {
                return "login";
        }

        @GetMapping("/signup")
        public String signup() {
                return "signup";
        }

        @PostMapping("/signup")
        // @ResponseBody
        public ResponseEntity<String> signedUp(@RequestBody PrivateUserDto dto) {
                System.out.println("signin dto: " + dto);
                userService.registerUser(dto);
                return new ResponseEntity<>("Success Sign-in", HttpStatus.OK);
                
        }
        @PostMapping("/login2")
        // @ResponseBody
        public ResponseEntity<String> loggedIn(@RequestBody PrivateUserDto dto) {
                System.out.println("login :" + dto);

                return new ResponseEntity<>("Success Log in", HttpStatus.OK);
        }
        
        
}
