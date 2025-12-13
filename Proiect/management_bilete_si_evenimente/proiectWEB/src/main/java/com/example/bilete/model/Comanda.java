package com.example.bilete.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Utilizator utilizator;

    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL)
    private List<Bilet> bilete;

    private BigDecimal total;
    private String status; // Ex: PENDING, PLATITA, ANULATA

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Utilizator getUtilizator() { return utilizator; }
    public void setUtilizator(Utilizator utilizator) { this.utilizator = utilizator; }

    public List<Bilet> getBilete() { return bilete; }
    public void setBilete(List<Bilet> bilete) { this.bilete = bilete; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}