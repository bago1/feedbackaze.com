package com.feedback.website.dtos;

import lombok.*;
import java.util.List;

@Data
public class UserDto {
    private String ad;
    private String soyad;
    private String email;
    private String password;
    private List<CommentDto> commentsDto;
}