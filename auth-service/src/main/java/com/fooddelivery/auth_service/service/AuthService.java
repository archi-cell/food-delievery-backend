package com.fooddelivery.auth_service.service;

import com.fooddelivery.auth_service.entity.User;
import com.fooddelivery.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }
}
