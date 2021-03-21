package com.feedback.website.controllers;

import com.feedback.website.models.Comment;
import com.feedback.website.models.User;
import com.feedback.website.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> getComments(){
        return commentService.getAll();
    }

    @GetMapping("/comments/{id}")
    public Optional<Comment> getAComment(@PathVariable Integer id){
        return commentService.findById(id);
    }

    /*Todo: burda url sadece comments ola biler. bele ki GET comments olarsa comentleri qaytarir. POST commentdirse comment store edir, delete silir mentiqi ile :) */
    @PostMapping("/comments/create")
    public void saveComment(@RequestBody Comment comment){
        commentService.saveComment(comment);
    }

    @PutMapping("/comments/{id}/update")
    public void updateComment(@PathVariable Integer id, @RequestBody Map<Object, Object> fields){
        //Birbasa update verende requestde ancaq 1 field varsa (hansi ki update edilir) digerleri avtomatik null edir save edir. qarsisini almaq ucun ancaq reuquestde olanlari save edirik.
//        commentService.updateComment(comment);
        Comment myComment = commentService.findById(id).get();
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Comment.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, myComment, value);
        });
        commentService.updateComment(myComment);
    }

    @DeleteMapping("/comments/{id}/delete")
    public void deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
    }


    /*User based comments */
    @GetMapping("/comments/{id}/user")
    public User getUserOfComment(@PathVariable Integer id){
        Optional<Comment> comment = commentService.findById(id);
        if (comment.isPresent()){
            Comment newComment = comment.get();
            return newComment.getUser();
        }
        return null;
    }
}
