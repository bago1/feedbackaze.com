package com.feedback.website.entities;

import java.util.List;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "users")
public class UserEntity extends PersonEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;



}

