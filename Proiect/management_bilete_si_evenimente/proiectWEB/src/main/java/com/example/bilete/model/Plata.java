package com.example.bilete.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Plata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Comanda comanda;

    private String metoda; // Ex: Card, PayPal
    private BigDecimal suma;
    private String status; // INITIATA, CONFIRMATA, EROARE

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Comanda getComanda() { return comanda; }
    public void setComanda(Comanda comanda) { this.comanda = comanda; }

    public String getMetoda() { return metoda; }
    public void setMetoda(String metoda) { this.metoda = metoda; }

    public BigDecimal getSuma() { return suma; }
    public void setSuma(BigDecimal suma) { this.suma = suma; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}