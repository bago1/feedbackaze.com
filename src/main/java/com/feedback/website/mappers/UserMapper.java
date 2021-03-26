package com.feedback.website.mappers;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.models.User;
import org.mapstruct.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper(componentModel = "spring", uses = CommentMapper.class)
@Repository
public interface UserMapper {

    @Mapping(source = "ad", target = "name")
    @Mapping(source = "soyad", target = "surname")
    User dtoToEntity(UserDto dto);

    @Mapping(source = "name", target = "ad")
    @Mapping(source = "surname", target = "soyad")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    UserDto entityToDto(User entity);

    List<UserDto> entityListToDtoList(List<User> entityList);
    List<User> dtoListtoEntityList(List<UserDto> dtoList);


}
