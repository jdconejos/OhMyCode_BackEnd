package com.ohmycode.rest.DTOs;

import com.ohmycode.domain.models.Address;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class DTOUser {
    private Long id;
    private String name;
    private String username;
    private DTOAddress address;

    public DTOUser() {
    }

    public DTOUser(Long id, String name, String username, DTOAddress address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.address = address;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DTOAddress getAddress() {
        return address;
    }

    public void setAddress(DTOAddress address) {
        this.address = address;
    }
}
