package com.demoorg.demowebapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
// Adding the table name
@Getter
@Setter
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cityName;

}