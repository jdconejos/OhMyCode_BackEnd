package com.ohmycode.domain.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TODOs")
public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="completed")
    private Boolean completed;

    @ManyToOne
    private User user;

    public Todo() {
    }

    public Todo(Long id, String title, Boolean completed, User user) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
