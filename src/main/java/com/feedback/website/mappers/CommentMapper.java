package com.feedback.website.mappers;

import com.feedback.website.dtos.CommentDto;
import com.feedback.website.entities.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = UserMapper.class)
public interface CommentMapper {



    Comment dtoToEntity(CommentDto dto);
    CommentDto entityToDto(Comment entity);


}
