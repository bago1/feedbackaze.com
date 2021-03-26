package com.feedback.website.dtos;

import com.feedback.website.models.Comment;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    public String ad;
    public String soyad;
    public String email;
    public String password;
    public List<Comment> comments;


}