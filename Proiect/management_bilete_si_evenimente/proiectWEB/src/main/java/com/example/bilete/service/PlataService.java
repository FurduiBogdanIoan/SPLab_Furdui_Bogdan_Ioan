package com.example.bilete.service;

import org.springframework.stereotype.Service;

import com.example.bilete.model.Comanda;
import com.example.bilete.model.Plata;
import com.example.bilete.repository.PlataRepository;

import java.util.Optional;
import java.util.List;

@Service
public class PlataService {

    private final PlataRepository repo;

    public PlataService(PlataRepository repo) {
        this.repo = repo;
    }

    public List<Plata> getAll() {
        return repo.findAll();
    }

    public Optional<Plata> getByComanda(Comanda comanda) {
        return repo.findByComanda(comanda);
    }

    public Plata save(Plata p) {
        return repo.save(p);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}