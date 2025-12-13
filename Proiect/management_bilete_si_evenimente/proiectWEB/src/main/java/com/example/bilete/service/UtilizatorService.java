package com.example.bilete.service;

import org.springframework.stereotype.Service;

import com.example.bilete.model.Utilizator;
import com.example.bilete.repository.UtilizatorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtilizatorService {

    private final UtilizatorRepository repo;

    public UtilizatorService(UtilizatorRepository repo) {
        this.repo = repo;
    }

    public List<Utilizator> getAll() {
        return repo.findAll();
    }

    public Optional<Utilizator> getById(Long id) {
        return repo.findById(id);
    }

    public Utilizator save(Utilizator u) {
        return repo.save(u);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Optional<Utilizator> getByEmail(String email) {
        return repo.findByEmail(email);
    }
}