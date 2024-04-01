package com.example.videostorebackend.services;


import com.example.videostorebackend.models.User;
import com.example.videostorebackend.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> getUsers(){
        return repository.findAll();
    }

    public void insertIntoUsers(User user){
        repository.insert(user);
    }
}
