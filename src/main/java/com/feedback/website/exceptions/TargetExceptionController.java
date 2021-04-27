package com.feedback.website.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TargetExceptionController {
    @ExceptionHandler(value = TargetNotFoundException.class)
    public ResponseEntity<Object> exception(TargetNotFoundException exception) {
        return new ResponseEntity<>("Target not found", HttpStatus.NOT_FOUND);
    }
}



