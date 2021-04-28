package com.feedback.website.services;

import com.feedback.website.dtos.CommentDto;
import com.feedback.website.entities.CommentEntity;
import com.feedback.website.exceptions.TargetNotFoundException;
import com.feedback.website.exceptions.UserNotFoundException;
import com.feedback.website.mappers.CommentMapper;
import com.feedback.website.repos.CommentRepo;
import com.feedback.website.repos.TargetRepo;
import com.feedback.website.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;
    private final CommentRepo commentRepo;
    private final TargetRepo targetRepo;
    private final UserRepo userRepo;

    public List<CommentDto> getAll() {
        return commentMapper.entityListToDtoList(commentRepo.findAll());
    }

    public CommentDto findById(Integer id) {
        return commentMapper.entityToDto(commentRepo.findById(id).orElseThrow());
    }


    public void saveComment(int id, CommentDto commentDto) {
        CommentEntity commentEntity = commentMapper.dtoToEntity(commentDto);

        commentEntity.setTargetEntity(targetRepo.findById(id).orElseThrow(TargetNotFoundException::new));
        if(!userRepo.findById(commentEntity.getUserEntity().getId()).isPresent()){
         throw new UserNotFoundException();
        }
        commentEntity.setUserEntity(commentEntity.getUserEntity());

        System.out.println(commentEntity.getUserEntity().getId());

        commentRepo.save(commentEntity);
    }


    public void updateComment(int id, Map<Object, Object> fields) {
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
