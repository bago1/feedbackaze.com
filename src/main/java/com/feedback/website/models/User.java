package com.feedback.website.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends Person{
    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

        @OneToMany(mappedBy = "user")//todo fetch = fetchType hem eager ve lazy yazanda da
    //@JsonManagedReference
    List<Comment> comments;
}

