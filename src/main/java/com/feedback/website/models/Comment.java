package com.feedback.website.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //todo generationtype auto, identity, sequence ferlqeri nedi
    Integer id;

    @Column(name = "comment_text")
    String commentText;

    @Column(name = "target_id")
    Integer targetId;

    @ManyToOne
    @JoinColumn
    private User user;
}
