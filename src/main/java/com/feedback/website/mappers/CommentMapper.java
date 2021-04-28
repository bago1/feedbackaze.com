package com.feedback.website.mappers;

import com.feedback.website.dtos.CommentDto;
import com.feedback.website.dtos.UserDto;
import com.feedback.website.entities.CommentEntity;
import com.feedback.website.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentEntity dtoToEntity(CommentDto dto);

    @Mapping(source = "targetEntity", target = "target")
    @Mapping(source = "userEntity", target = "user")
    CommentDto entityToDto(CommentEntity entity);

    List<CommentDto> entityListToDtoList(List<CommentEntity> entityList);



}
