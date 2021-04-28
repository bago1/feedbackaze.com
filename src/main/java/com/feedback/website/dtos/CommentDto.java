package com.feedback.website.dtos;

import com.feedback.website.entities.TargetEntity;
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
    String commentText;
    TargetEntity targetEntity;
    UserEntity userEntity;
}




