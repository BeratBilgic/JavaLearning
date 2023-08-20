package com.example.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "MyUsers")
@ApiModel(value = "My User Table", description = "My User Table description" )
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "My User Table's ID")
    private Long id;

    @ApiModelProperty(value = "My User Table's name")
    private String name;

    @ApiModelProperty(value = "My User Table's surname")
    private String surname;

    public MyUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
