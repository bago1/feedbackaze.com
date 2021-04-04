package com.feedback.website.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
