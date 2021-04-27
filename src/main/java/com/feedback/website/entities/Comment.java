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

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "test_name", nullable = false,updatable = false, insertable = false)
    TargetEntity targetEntity;

    @ManyToOne(cascade = {CascadeType.ALL})
   // @JoinColumn(updatable = false, insertable = false)
    UserEntity userEntity;

//todo insertable, updateable false secende yeni row yaradir, secmeyende ise hemin idni tapib calaya bilmir


}
