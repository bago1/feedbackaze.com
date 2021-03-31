package com.feedback.website.entities;


import javax.persistence.*;

import lombok.*;


@MappedSuperclass
@Data
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;




}