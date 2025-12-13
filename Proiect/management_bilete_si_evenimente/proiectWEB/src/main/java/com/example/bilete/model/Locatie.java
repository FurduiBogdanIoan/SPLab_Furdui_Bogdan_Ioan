package com.example.bilete.model;


import jakarta.persistence.*;

@Entity
public class Locatie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private String adresa;
    private String oras;
    private Integer capacitate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }

    public String getOras() { return oras; }
    public void setOras(String oras) { this.oras = oras; }

    public Integer getCapacitate() { return capacitate; }
    public void setCapacitate(Integer capacitate) { this.capacitate = capacitate; }
}