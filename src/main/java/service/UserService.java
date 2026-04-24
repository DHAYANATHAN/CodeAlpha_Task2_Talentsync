package com.talentsync.talentsync.service;

import com.talentsync.talentsync.model.User;
import com.talentsync.talentsync.repository.UserRepository;
import com.talentsync.talentsync.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ REGISTER USER
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // ✅ LOGIN USER (SAFE VERSION)
    public User login(LoginRequest request) {
        return userRepository
                .findByEmailAndPassword(request.getEmail(), request.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}