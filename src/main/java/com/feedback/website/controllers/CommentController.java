package com.feedback.website.controllers;

import com.feedback.website.dtos.CommentDto;
import com.feedback.website.entities.CommentEntity;
import com.feedback.website.mappers.CommentMapper;
import com.feedback.website.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;


    @GetMapping("/comments/{id}")
    public CommentDto one(@PathVariable Integer id) {
        return commentService.findById(id);
    }

    @GetMapping("/comments")
    public List<CommentDto> all() {
        return commentService.getAll();
    }

    @PostMapping("/targets/{target_id}/comments")
    public ResponseEntity<CommentDto> saveComment(@PathVariable int target_id, @RequestBody CommentDto commentDto) {
        commentService.saveComment(target_id, commentDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Object> updateComment(@PathVariable Integer id, @RequestBody Map<Object, Object> fields) {

        commentService.updateComment(id, fields);
        return ResponseEntity.ok("Comment " + id + " updated");
    }

    //bura body yazmaq olmur. .ok() gonderesenki body yazasan.
    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Object> deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping("/comments")
    public ResponseEntity<Object> deleteComment() {
        commentService.deleteAllComments();
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
