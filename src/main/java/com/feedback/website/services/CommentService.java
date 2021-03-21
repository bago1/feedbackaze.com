package com.feedback.website.services;

import com.feedback.website.models.Comment;
import com.feedback.website.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    public List<Comment> getAll() {
        return (List<Comment>) commentRepo.findAll();
    }

    public Optional<Comment> findById(Integer id) {
        return commentRepo.findById(id);
    }

    public void saveComment(Comment comment){
        commentRepo.save(comment);
    }

    /*Update vaxti elave nese etmeli ola bilerik. bu sebebe ayirdim funksiyani. Meselen event gondermek ki comment yenilendi. */
    public void updateComment(Comment comment){
        commentRepo.save(comment);
    }



    public void deleteComment(Integer id) {
        commentRepo.deleteById(id);
    }

}
