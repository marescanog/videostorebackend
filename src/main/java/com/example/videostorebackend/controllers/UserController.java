package com.example.videostorebackend.controllers;


import com.example.videostorebackend.models.User;
import com.example.videostorebackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping(value = "/users",consumes={MediaType.APPLICATION_JSON_VALUE})
    public void addMovie(@RequestBody User user){
        service.insertIntoUsers(user);
    }
}
