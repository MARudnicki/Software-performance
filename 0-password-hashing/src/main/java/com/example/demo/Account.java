package com.example.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Account {

    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private String password;

}
