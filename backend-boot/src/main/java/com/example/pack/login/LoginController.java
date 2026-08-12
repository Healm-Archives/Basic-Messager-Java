package com.example.pack.login;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class LoginController {

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
        public ResponseEntity<String> signUp(@Valid @RequestBody LoginUserDto dto) {
                return loginService.authenticateRegister(dto);
                
        }

        @PostMapping("/login")
        // @ResponseBody
        public ResponseEntity<LoginResponseDto> logIn(@Valid @RequestBody LoginUserDto dto) {
                return loginService.authenticateLogin(dto);
        }
        
        
}
