package com.example.bilete.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class TipBilet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private BigDecimal pret;
    private Integer stoc;

    @ManyToOne
    @JsonIgnoreProperties("tipuriBilet")
    private Eveniment eveniment;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public BigDecimal getPret() { return pret; }
    public void setPret(BigDecimal pret) { this.pret = pret; }

    public Integer getStoc() { return stoc; }
    public void setStoc(Integer stoc) { this.stoc = stoc; }

    public Eveniment getEveniment() { return eveniment; }
    public void setEveniment(Eveniment eveniment) { this.eveniment = eveniment; }
}