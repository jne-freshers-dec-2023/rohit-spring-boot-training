package com.example.rest.webservice.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
public class User{

    protected User()
    {

    }

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2,message ="name should not have atleast 2 character")
//    @JsonProperty("user_name")
    private String name;


    @Past(message = "birth date should be past")
//    @JsonProperty("user_DOB")
    private LocalDate dateofbirth;

    @OneToMany(mappedBy="user")
    @JsonIgnore
    private List<Post> posts;

    public User(Integer id, String name, LocalDate dateofbirth) {
        this.id = id;
        this.name = name;
        this.dateofbirth = dateofbirth;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateofbirth=" + dateofbirth +
                '}';
    }
}
