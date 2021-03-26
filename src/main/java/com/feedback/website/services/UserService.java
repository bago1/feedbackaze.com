package com.feedback.website.services;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.mappers.UserMapper;
import com.feedback.website.models.Comment;
import com.feedback.website.models.User;
import com.feedback.website.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentService commentService;

    //list
    public List<User> listUsers() {
        return userRepo.findAll();
    }

    //listCorrect
    public List<UserDto> listUsersCorrect() {
        return userMapper.entityListToDtoList(userRepo.findAll());
    }


    public void saveSampleUser() {


        Comment comment = new Comment();
        comment.setCommentText(" test comment text");
        commentService.saveComment(comment);

        User user = new User();
        user.setName("test username");
        user.setPassword("test userpass");
        user.setEmail("test useremail");

        comment.setUser(user);

        userRepo.save(user);
    }


    public void saveUser(UserDto userDto) {

        User user = new User();
        user.setName(userDto.getAd());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        userRepo.save(user);


    }

    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    public void deleteAllUsers() {
        userRepo.deleteAll();
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