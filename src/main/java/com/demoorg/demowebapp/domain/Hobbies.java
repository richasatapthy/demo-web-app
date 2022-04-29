package com.demoorg.demowebapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="hobbies")
@Getter
@Setter

public class Hobbies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Hobbies_id;

    @Column(name="name")
    private String name;

}

