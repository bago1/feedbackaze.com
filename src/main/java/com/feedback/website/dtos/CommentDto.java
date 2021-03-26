package com.feedback.website.dtos;

import com.feedback.website.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    Integer id;
  //  Integer userId;
    String commentText;
    Integer targetId;
    User user;


}
