package com.talentsync.talentsync.controller;

import com.talentsync.talentsync.model.User;
import com.talentsync.talentsync.dto.LoginRequest;
import com.talentsync.talentsync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.talentsync.talentsync.repository.ApplicationRepository;


@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationRepository applicationRepository;


    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

}