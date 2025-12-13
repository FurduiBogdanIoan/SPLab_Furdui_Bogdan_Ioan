package com.example.bilete.service;

import org.springframework.stereotype.Service;

import com.example.bilete.model.Organizator;
import com.example.bilete.repository.OrganizatorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizatorService {

    private final OrganizatorRepository repo;

    public OrganizatorService(OrganizatorRepository repo) {
        this.repo = repo;
    }

    public List<Organizator> getAll() {
        return repo.findAll();
    }

    public Optional<Organizator> getById(Long id) {
        return repo.findById(id);
    }

    public Organizator save(Organizator o) {
        return repo.save(o);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}