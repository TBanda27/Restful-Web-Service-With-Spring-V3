package com.restful_webservices.rest.post;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restful_webservices.rest.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2)
    @NotBlank
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post(Integer id, String description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
