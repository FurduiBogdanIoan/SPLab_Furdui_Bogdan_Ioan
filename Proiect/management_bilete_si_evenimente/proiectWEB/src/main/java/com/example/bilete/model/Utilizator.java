package com.example.bilete.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Utilizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private String email;
    private String parola;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "utilizator_rol",
        joinColumns = @JoinColumn(name = "utilizator_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roluri = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getParola() { return parola; }
    public void setParola(String parola) { this.parola = parola; }

    public Set<Rol> getRoluri() { return roluri; }
    public void setRoluri(Set<Rol> roluri) { this.roluri = roluri; }
}