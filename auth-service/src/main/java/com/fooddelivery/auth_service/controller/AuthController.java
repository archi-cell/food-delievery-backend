package com.fooddelivery.auth_service.controller;

import com.fooddelivery.auth_service.entity.User;
import com.fooddelivery.auth_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000") // React frontend
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user.getUsername(), user.getEmail(), user.getPassword());
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean success = userService.loginUser(user.getUsername(), user.getPassword());
        return success ? "Login Successful" : "Invalid credentials";
    }
}

