package com.feedback.website.mappers;

import com.feedback.website.dtos.CommentDto;
import com.feedback.website.entities.CommentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {


    CommentEntity dtoToEntity(CommentDto dto);

    CommentDto entityToDto(CommentEntity entity);


}
