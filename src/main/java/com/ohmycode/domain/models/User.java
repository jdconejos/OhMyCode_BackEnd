package com.ohmycode.domain.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_entity")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="username", unique=true)
    private String username;

    @Column(name="password")
    private String password;

    @ManyToOne
    private Address address;

    public User() {
    }

    public User(Long id, String name, String username, String password, Address address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
