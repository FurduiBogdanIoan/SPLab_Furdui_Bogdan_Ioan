package com.example.bilete.service;

import org.springframework.stereotype.Service;

import com.example.bilete.model.Bilet;
import com.example.bilete.model.Comanda;
import com.example.bilete.repository.BiletRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BiletService {

    private final BiletRepository repo;

    public BiletService(BiletRepository repo) {
        this.repo = repo;
    }

    public List<Bilet> getAll() {
        return repo.findAll();
    }

    public List<Bilet> getByComanda(Comanda comanda) {
        return repo.findByComanda(comanda);
    }

    public Optional<Bilet> getByCodUnic(String codUnic) {
        return repo.findByCodUnic(codUnic);
    }

    public Bilet save(Bilet b) {
        return repo.save(b);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}