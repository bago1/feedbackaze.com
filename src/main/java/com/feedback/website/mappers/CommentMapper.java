package com.feedback.website.mappers;

import com.feedback.website.dtos.CommentDto;
import com.feedback.website.dtos.UserDto;
import com.feedback.website.models.Comment;
import com.feedback.website.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = UserMapper.class)
public interface CommentMapper {



    Comment dtoToEntity(CommentDto dto);
    CommentDto entityToDto(Comment entity);


}
