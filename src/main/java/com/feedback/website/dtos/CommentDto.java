package com.feedback.website.dtos;

import com.feedback.website.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {

    Integer id;
    String commentText;
    Integer targetId;
    UserEntity userEntity;

}
