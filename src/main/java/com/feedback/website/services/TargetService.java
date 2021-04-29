package com.feedback.website.services;

import com.feedback.website.dtos.TargetDto;
import com.feedback.website.entities.TargetEntity;
import com.feedback.website.exceptions.TargetNotFoundException;
import com.feedback.website.exceptions.UserNotFoundException;
import com.feedback.website.mappers.TargetMapper;
import com.feedback.website.repos.TargetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TargetService {

    private final TargetRepo targetRepo;
    private final TargetMapper targetMapper;
    private final CommentService commentService;


    public void saveTarget(TargetDto targetDto) {
        targetRepo.save(targetMapper.dtoToEntity(targetDto));
    }

    public TargetDto getOneTarget(int id) {
        return targetMapper.entityToDto(targetRepo.findById(id).orElseThrow(TargetNotFoundException::new));
    }

    public List<TargetDto> getAllTargets() {
        return targetMapper.entityListToDtoList(targetRepo.findAll());
    }

    public void updateTarget(TargetDto targetDto, int id) {

        TargetEntity existingEntity = targetRepo.findById(id).orElseThrow(TargetNotFoundException::new);
        TargetEntity newEntity = targetMapper.dtoToEntity(targetDto);
        existingEntity.setName(newEntity.getName());
        targetRepo.save(existingEntity);

    }


    public void deleteTarget(int id) {
        targetRepo.findById(id).orElseThrow(TargetNotFoundException::new);
        commentService.deleteAllCommentsByTargetId(id);
        targetRepo.deleteById(id);}

    public void deleteAllTargets() {
        targetRepo.deleteAll();
    }
}
