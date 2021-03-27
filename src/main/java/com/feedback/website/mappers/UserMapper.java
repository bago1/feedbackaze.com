package com.feedback.website.mappers;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.models.User;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = CommentMapper.class)
@Repository
public interface UserMapper {

    @Mapping(source = "ad", target = "name")
    @Mapping(source = "soyad", target = "surname")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User dtoToEntity(UserDto dto);

    @Mapping(source = "name", target = "ad")
    @Mapping(source = "surname", target = "soyad")
    UserDto entityToDto(User entity);

    List<UserDto> entityListToDtoList(List<User> entityList);
    List<User> dtoListtoEntityList(List<UserDto> dtoList);


}
