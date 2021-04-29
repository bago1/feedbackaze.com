package com.feedback.website.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommentExceptionController {
    @ExceptionHandler(value = CommentNotFoundException.class)
    public ResponseEntity<Object> exception(CommentNotFoundException exception) {
        return new ResponseEntity<>("Comment not found", HttpStatus.NOT_FOUND);
    }
}



