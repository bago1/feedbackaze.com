package com.feedback.website.controllers;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.models.Comment;
import com.feedback.website.models.User;
import com.feedback.website.services.UserService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    @GetMapping(value = "/users")
    public List<UserDto> getAllUsers() {
        return userService.listUsers();
    }

    @PostMapping(value = "/registerUser")
    public List<UserDto> addUser(@RequestBody UserDto userDto) {
        System.out.println("ss");
        userService.saveUser(userDto);
        return userService.listUsers();
    }


}
