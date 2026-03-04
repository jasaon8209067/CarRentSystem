package com.example.demo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1")
public class LoginControllerTest {
    @PostMapping("/login")
    public String login (@RequestParam String username, @RequestParam String password){
        return "帳號:" + username + "，密碼:" + password;

    }
}
