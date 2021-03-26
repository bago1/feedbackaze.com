package com.feedback.website.dtos;

import com.feedback.website.models.Comment;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    public String ad;
    public String soyad;
    private String email;
    private String password;
    private List<Comment> comments;


}