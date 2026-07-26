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
@RequestMapping(path = "/api/v1")
public class LoginController {


        private final LoginService loginService;

        public LoginController(LoginService loginService) {
                this.loginService = loginService;
        }

        // @GetMapping("/login")
        // public String login() {
        //         return "login";
        // }

        // @GetMapping("/signup")
        // public String signup() {
        //         return "signup";
        // }

        @PostMapping("/signin")
        // @ResponseBody
        public ResponseEntity<String> signedUp(@RequestBody PrivateUserDto dto) {
                return loginService.authenticateRegister(dto);
                
        }

        @PostMapping("/login")
        // @ResponseBody
        public ResponseEntity<String> loggedIn(@RequestBody PrivateUserDto dto) {
                return loginService.authenticateLogin(dto);
        }
        
        
}
