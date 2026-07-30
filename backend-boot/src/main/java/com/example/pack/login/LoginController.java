package com.example.pack.login;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pack.user.PrivateUserDto;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class LoginController {

        // private final CustomUserDetailsService loginService;
        private final LoginService loginService;

        // @GetMapping("/login")
        // public String login() {
        //         return "login";
        // }

        // @GetMapping("/signup")
        // public String signup() {
        //         return "signup";
        // }

        @PostMapping("/register")
        // @ResponseBody
        public ResponseEntity<String> signedUp(@RequestBody PrivateUserDto dto) {
                return loginService.authenticateRegister(dto);
                
        }

        @PostMapping("/login")
        // @ResponseBody
        // public ResponseEntity<String> loggedIn(@RequestBody PrivateUserDto dto) {
        public ResponseEntity<LoginResponseDto> loggedIn(@RequestBody PrivateUserDto dto) {
                return loginService.authenticateLogin(dto);
        }
        
        
}
