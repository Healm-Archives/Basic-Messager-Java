package com.example.pack.login;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pack.user.PrivateUserDto;



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
