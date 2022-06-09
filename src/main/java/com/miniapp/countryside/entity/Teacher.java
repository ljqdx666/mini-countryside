package com.miniapp.countryside.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Teacher {
    @Id
    @Column(unique = true)
    private  String username;

    public  String password;
}
