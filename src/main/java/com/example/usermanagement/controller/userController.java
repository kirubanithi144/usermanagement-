package com.example.usermanagement.controller;

import com.example.usermanagement.service.UserService;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        try {
            User loggedInUser = userService.login(user.getEmail(), user.getPassword());
            return "Login successfully " + loggedInUser.getName();
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping
    public List<User>getAllUser(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id ){
        return userService.getUserById(id).orElseThrow(()->new RuntimeException("User not found"));
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User userDetails){
        return userService.updateUser(id,userDetails);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User deleted successfully";
    }
    @PostMapping("/bulk")
    public List<User> createMultipleUsers(@RequestBody List<User> users) {
        return userService.createMultipleUsers(users);
    }


}