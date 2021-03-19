package com.feedback.website.controllers;

import com.feedback.website.models.User;
import com.feedback.website.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //UserRegister
    @PostMapping("/users/register")//request body post gonderende bodysi olmasi ucun
    public void registerUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping("/users/update")//request body post gonderende bodysi olmasi ucun
    public void updateUser(@RequestBody User user) {
        userService.saveUser(user);
    }


    @GetMapping("/user")
    public Optional<User> getUserById(Integer id) {
        System.out.println(id);
        return userService.getById(id);
    }

    @GetMapping("/users")
    public List<User> getallUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }
















}
