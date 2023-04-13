package com.example.app.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ecole {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;


    @Column(unique = true)
    private String name;
    private String address;
    private String contact;

    @OneToMany
    private List<Classroom> classrooms = new ArrayList<>();
    public Ecole() {

    }
    public Ecole (String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

