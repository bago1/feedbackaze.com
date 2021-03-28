package com.feedback.website.controllers;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.mappers.UserMapper;
import com.feedback.website.repos.UserRepo;
import com.feedback.website.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private  final UserRepo userRepo;
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/all")
    @ResponseBody
    public List<UserDto> getAllUsers() {
        return userService.listUsers();

    }

    @DeleteMapping(value = "/all")
    @ResponseBody
    public List<UserDto> deleteAllUsers() {
        return userService.deleteAllUsers();

    }

    @GetMapping(value = "/{id}")
    public UserDto getOneUser(@PathVariable Integer id) {
        return userService.getOneUser(id);
    }

    @DeleteMapping(value = "/{id}")
    public List<UserDto>  deleteUser(@PathVariable Integer id) {
         userService.deleteOneUser(id);
        return getAllUsers();
    }

    @PostMapping(value = "/register")
    public List<UserDto> addUser(@RequestBody UserDto userDto) {
        System.out.println(userDto.toString());
        userService.saveUser(userDto);
        return userService.listUsers();
    }

    @PutMapping(value = "/update/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Integer id) throws Exception {
        userService.updateUser(userDto,id);
        return getOneUser(id);
    }

}
