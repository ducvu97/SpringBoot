package com.example.SpringBootLogin.controller;

import com.example.SpringBootLogin.model.User;
import com.example.SpringBootLogin.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = {"/", "/home"})
    public String homepage() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


//    @Autowired
//    PasswordEncode passwordEncode;

    @PostMapping("/input")
    public void save(@RequestParam("username") String username, @RequestParam("password") String password) {
        User n = new User();
        n.setUsername(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        n.setPassword(passwordEncoder.encode(password));
        userRepository.save(n);
    }
    @GetMapping("/signin")
    public String signin(){
        return "input";
    }
}