package com.example.quizApp.controller;

import com.example.quizApp.entity.User;
import com.example.quizApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // Path for managing user operations
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Add a new user
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser); // Return the saved user as a response
    }
}
