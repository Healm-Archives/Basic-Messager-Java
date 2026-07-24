package com.example.pack.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/req")
public class LoginController {
        @GetMapping("/login")
        public String login() {
            return "login";
        }
        
        @GetMapping("/signup")
        public String signup() {
            return "signup";
        }
        
}
