package com.feedback.website.services;

import com.feedback.website.exceptions.UserNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceTest {

    UserNotFoundException userNotFoundException = new UserNotFoundException();


    //as a user, when i save comment , if user doesnt exist throw user not found exception
    @Test
    void WhenAddNewCommentIfUserLacksThrowUserNotFOundException() {


    }

}