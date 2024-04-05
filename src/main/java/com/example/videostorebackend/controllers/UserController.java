package com.example.videostorebackend.controllers;


import com.example.videostorebackend.component.SignUpRequest;
import com.example.videostorebackend.models.User;
import com.example.videostorebackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/users")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping(value = "/users",consumes={MediaType.APPLICATION_JSON_VALUE})
    public void addMovie(@RequestBody User user){
        service.insertIntoUsers(user);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignUpRequest signUpRequest) {

        if (service.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(Map.of("email", "Email is already in use!"));
        }
        if (!signUpRequest.getPassword().equals(signUpRequest.getConfirmPassword())) {
            return ResponseEntity.badRequest().body(Map.of("password", "Passwords do not match!"));
        }
        User user = new User();
        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setRole("user");
        service.createUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @GetMapping("/singleUser/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        Optional<User> found = service.getUserById(id);

        if(found.isPresent()){

            return ResponseEntity.ok(found);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "User not found!"));
    }
}
