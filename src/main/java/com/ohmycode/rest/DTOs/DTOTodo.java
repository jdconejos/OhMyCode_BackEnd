package com.ohmycode.rest.DTOs;

public class DTOTodo {
    private Long id;
    private String title;
    private Boolean completed;
    private DTOUser user;

    public DTOTodo() {
    }

    public DTOTodo(DTOUser user, Long id, String title, Boolean completed) {
        this.user = user;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public DTOUser getUser() {
        return user;
    }

    public void setUser(DTOUser user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
