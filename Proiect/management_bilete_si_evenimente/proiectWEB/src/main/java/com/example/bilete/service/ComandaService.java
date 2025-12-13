package com.example.bilete.service;

import org.springframework.stereotype.Service;

import com.example.bilete.model.Comanda;
import com.example.bilete.model.Utilizator;
import com.example.bilete.repository.ComandaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComandaService {

    private final ComandaRepository repo;

    public ComandaService(ComandaRepository repo) {
        this.repo = repo;
    }

    public List<Comanda> getAll() {
        return repo.findAll();
    }

    public Optional<Comanda> getById(Long id) {
        return repo.findById(id);
    }

    public List<Comanda> getByUtilizator(Utilizator utilizator) {
        return repo.findByUtilizator(utilizator);
    }

    public Comanda save(Comanda c) {
        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}