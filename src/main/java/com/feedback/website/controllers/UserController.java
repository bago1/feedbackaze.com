package com.feedback.website.controllers;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;


    @GetMapping(value = "/all")
    @ResponseBody
    public List<UserDto> getAllUsers(@PathVariable int id) {

        return userService.listUsers();

    }

    @GetMapping(value = "/{id}")
    public UserDto getUser(@PathVariable int id) {
        return userService.getOneUser(id);


    }

    @PostMapping(value = "/register")
    public List<UserDto> addUser(@RequestBody UserDto userDto) {
        System.out.println(userDto.toString());
        userService.saveUser(userDto);
        return userService.listUsers();
    }


}
