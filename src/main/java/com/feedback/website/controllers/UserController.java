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
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);





    @GetMapping(value = "/list")
    public List<User> getOwners() {
        return userService.listUsers();
    }

    @GetMapping(value = "/listCorrect")
    public List<UserDto> getOwnersCorrect() {
        return userService.listUsersCorrect();
    }

    @GetMapping(value = "/add")
    public List<UserDto> addUser() {
        userService.saveSampleUser();
        logger.info("new user added");
        return userService.listUsersCorrect();
    }


}
