package com.example.videostorebackend.services;


import com.example.videostorebackend.models.User;
import com.example.videostorebackend.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsManager {

    @Autowired
    private UserRepository repository;

    public List<User> getUsers(){
        return repository.findAll();
    }

    public void insertIntoUsers(User user){
        repository.insert(user);
    }

    public boolean existsByEmail(String email) {
        return repository.findByEmail(email) != null;
    }

    @Override
    public void createUser(UserDetails user) {
        repository.save((User) user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("hi");
        return repository.findByEmail(username);
    }
}
