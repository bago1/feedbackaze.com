package com.feedback.website.services;

import com.feedback.website.dtos.CommentDto;
import com.feedback.website.entities.CommentEntity;
import com.feedback.website.exceptions.TargetNotFoundException;
import com.feedback.website.mappers.CommentMapper;
import com.feedback.website.mappers.UserMapper;
import com.feedback.website.repos.CommentRepo;
import com.feedback.website.repos.TargetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import javax.xml.stream.events.Comment;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;
    private final CommentRepo commentRepo;

    private final TargetRepo targetRepo;

    public List<CommentEntity> getAll() {
        return (List<CommentEntity>) commentRepo.findAll();
    }

    public Optional<CommentEntity> findById(Integer id) {
        return commentRepo.findById(id);
    }



    public void saveComment(int id, CommentDto commentDto) {
        CommentEntity commentEntity = commentMapper.dtoToEntity(commentDto);

        commentEntity.setTargetEntity(targetRepo.findById(id).orElseThrow(TargetNotFoundException::new));
        commentEntity.setUserEntity(commentEntity.getUserEntity());
        commentRepo.save(commentEntity);

    }


    public void updateComment(int id, Map<Object, Object> fields ) {
        CommentEntity myCommentEntity = commentRepo.findById(id).get();
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(CommentEntity.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, myCommentEntity, value);
        });

        commentRepo.save(myCommentEntity);
    }


    public void deleteComment(Integer id) {
        commentRepo.deleteById(id);
    }

    public void deleteAllComments() {
        commentRepo.deleteAll();
    }
}
