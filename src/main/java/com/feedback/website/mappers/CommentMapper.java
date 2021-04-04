package com.feedback.website.mappers;

import com.feedback.website.dtos.CommentDto;
import com.feedback.website.entities.Comment;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CommentMapper {


    Comment dtoToEntity(CommentDto dto);

    CommentDto entityToDto(Comment entity);


}
