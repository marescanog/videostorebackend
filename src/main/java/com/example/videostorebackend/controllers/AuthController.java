package com.example.videostorebackend.controllers;

import com.example.videostorebackend.models.User;
import com.example.videostorebackend.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/user")
    public User getUserDetailsAfterLogin(Authentication authentication) {
        System.out.println("hi");
        List<User> users = repository.findAllByEmail(authentication.getName());
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
