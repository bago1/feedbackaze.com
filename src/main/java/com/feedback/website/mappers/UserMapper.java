package com.feedback.website.mappers;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.models.User;
import org.mapstruct.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper(componentModel = "spring", uses = CommentMapper.class)
@Repository
public interface UserMapper {

    User dtoToEntity(UserDto dto);

    @Mapping(source = "name", target = "ad")
    @Mapping(source = "surname", target = "soyad")
    UserDto entityToDto(User entity);
    List<UserDto> entityListToDtoList(List<User> entityList);
    List<User> dtoListtoEntityList(List<UserDto> dtoList);


}
