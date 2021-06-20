package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private int home;

    public Address(String name, int home) {
        this.street = name;
        this.home = home;
    }

    public Address() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String name) {
        this.street = name;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }
}
