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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "comment_text")
    String commentText;

    @Column(name = "target_id")
    Integer targetId;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    @JsonBackReference
    private User user;
}
