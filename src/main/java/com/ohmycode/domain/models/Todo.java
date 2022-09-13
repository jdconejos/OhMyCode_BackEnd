package com.ohmycode.domain.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TODOs")
public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="completed", nullable = false)
    private Boolean completed;

    @ManyToOne
    private UserDao userDao;

    public Todo() {
    }

    public Todo(Long id, String title, Boolean completed, UserDao userDao) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.userDao = userDao;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public UserDao getUser() {
        return userDao;
    }

    public void setUser(UserDao userDao) {
        this.userDao = userDao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
