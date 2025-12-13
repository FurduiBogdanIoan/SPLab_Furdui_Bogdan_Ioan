package com.example.bilete.model;

import jakarta.persistence.*;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume; // user, admin 

    public Rol() {}
    public Rol(String nume) { this.nume = nume; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
}