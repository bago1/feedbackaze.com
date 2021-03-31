package com.feedback.website.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //todo generationtype auto, identity, sequence ferlqeri nedi
    Integer id;

    @Column(name = "comment_text")
    String commentText;

    @Column(name = "target_id")
    Integer targetId;

    @ManyToOne
    @JoinColumn(updatable = false, insertable = false)
    UserEntity userEntity;


}
