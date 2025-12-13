package com.example.bilete.service;

import org.springframework.stereotype.Service;

import com.example.bilete.model.Rol;
import com.example.bilete.repository.RolRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    private final RolRepository repo;

    public RolService(RolRepository repo) {
        this.repo = repo;
    }

    public List<Rol> getAll() {
        return repo.findAll();
    }

    public Optional<Rol> findByNume(String nume) {
        return repo.findByNume(nume);
    }

    public Rol save(Rol r) {
        return repo.save(r);
    }
}