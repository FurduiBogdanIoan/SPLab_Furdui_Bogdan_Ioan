package com.example.bilete.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Organizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private String emailContact;
    private String telefon;

    @OneToMany(mappedBy = "organizator", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Eveniment> evenimente;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getEmailContact() { return emailContact; }
    public void setEmailContact(String emailContact) { this.emailContact = emailContact; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public List<Eveniment> getEvenimente() { return evenimente; }
    public void setEvenimente(List<Eveniment> evenimente) { this.evenimente = evenimente; }
}