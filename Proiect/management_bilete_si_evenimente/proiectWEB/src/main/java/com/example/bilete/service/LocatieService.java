package com.example.bilete.service;

import org.springframework.stereotype.Service;

import com.example.bilete.model.Locatie;
import com.example.bilete.repository.LocatieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocatieService {

    private final LocatieRepository repo;

    public LocatieService(LocatieRepository repo) {
        this.repo = repo;
    }

    public List<Locatie> getAll() {
        return repo.findAll();
    }

    public List<Locatie> getByOras(String oras) {
        return repo.findByOras(oras);
    }

    public Optional<Locatie> getById(Long id) {
        return repo.findById(id);
    }

    public Locatie save(Locatie l) {
        return repo.save(l);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}