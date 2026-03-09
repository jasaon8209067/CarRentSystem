//package com.example.demo.Controller;
//
//import com.example.demo.Entity.UserForm;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class LoginController {
//    @PostMapping("/login")
//    public String login(UserForm userForm) {
//        return "帳號:" + userForm.getUsername() +
//                "密碼:" + userForm.getPassword();
//    }
//
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "Hello Spring Boot";
//    }
//}