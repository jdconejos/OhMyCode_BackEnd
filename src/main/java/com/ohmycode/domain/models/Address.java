package com.ohmycode.domain.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="zipcode")
    private String zipcode;

    @Column(name="country")
    private String country;

    public Address() {
    }

    public Address(Long id, String street, String city, String zipcode, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
