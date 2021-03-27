package com.feedback.website.services;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.mappers.UserMapper;
import com.feedback.website.models.User;
import com.feedback.website.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentService commentService;


    //listCorrect
    public List<UserDto> listUsers() {
        return userMapper.entityListToDtoList(userRepo.findAll());
    }


    public void saveUser(UserDto userDto) {

        UserDto userDto1 = UserDto.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .ad(userDto.getAd())
                .soyad(userDto.getSoyad())
                .build();

        userRepo.save(userMapper.dtoToEntity(userDto1));


    }


    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    public void deleteAllUsers() {
        userRepo.deleteAll();
    }


    public UserDto getOneUser(int id) {

        return userMapper.entityToDto(userRepo.findById(id).orElse(null));
        //todo try catch - message
    }
}
//list
//[{"id":1,"name":"i am test user name",
// "surname":null,
// "email":"i am user test email",
// "password":"i am user test pass",
// "comments":[{"id":1,"commentText":"i am test comment text","targetId":null}]}]

//[{"name":"i am test user name",
// "surname":null,
// "email":"i am user test email",
// "password":"i am user test pass",
// "comments":[{"id":1,"commentText":"i am test comment text","targetId":null}]}]