package com.feedback.website.controllers;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/{id}")
    public UserDto one(@PathVariable Integer id) {
        return userService.getOneUser(id);
    }

    @GetMapping(value = "/")
    @ResponseBody
    public List<UserDto> all() {
        return userService.listUsers();
    }

    @PostMapping(value = "/")
    public ResponseEntity<UserDto> newUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto, @PathVariable Integer id) {
        userService.updateUser(userDto, id);
        return ResponseEntity.ok("user id=" + id + " updated");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        userService.deleteOneUser(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }


    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Object> deleteAllUsers() {
        userService.deleteAllUsers();
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
//get ve putda response entity-nin xususiyetlerinden istif elemeye ehtiyac yoxdur, cunki , tapilmayanda 404 qaytarir.
    //amma post edende bize lazimdir, 201 CREATED kodunu alaq, deletde ise 204 NO CONTENT kodunu alaq. buna gore Response Entiity yazirq. yazmasaq, delete edende 200(Ugurlu) qaytarir. sehv mesajdi
//get ve put ucun kod yoxdur xususi

    //something added
}


