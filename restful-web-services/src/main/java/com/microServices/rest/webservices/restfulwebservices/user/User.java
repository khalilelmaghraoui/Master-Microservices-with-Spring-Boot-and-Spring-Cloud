package com.microServices.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "all details about users")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

//    @ApiModelProperty (notes = "notes ") will take place in swaggers docs as description of each property

    @Size(min = 2)
    @ApiModelProperty(notes = "name should be at least 8 chars")
    private String name;

    @Past
    @JsonIgnore
    private Date date;

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", date=" + date +
            '}';
    }

    public User(Integer id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public User(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
