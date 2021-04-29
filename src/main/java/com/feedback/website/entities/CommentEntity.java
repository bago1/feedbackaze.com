package com.feedback.website.entities;

import javax.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String commentText;

    @ManyToOne
    TargetEntity targetEntity;

    @ManyToOne
    UserEntity userEntity;




}
