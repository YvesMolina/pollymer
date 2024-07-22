package com.example.pollymer.controller;

import com.example.pollymer.model.User;
import com.example.pollymer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/findByUsername")
    public Optional<User> findByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/findByEmail")
    public Optional<User> findByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }

}
