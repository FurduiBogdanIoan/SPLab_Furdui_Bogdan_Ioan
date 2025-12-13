package com.example.bilete.service;

import org.springframework.stereotype.Service;

import com.example.bilete.model.Eveniment;
import com.example.bilete.model.Organizator;
import com.example.bilete.repository.EvenimentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EvenimentService {

    private final EvenimentRepository repo;

    public EvenimentService(EvenimentRepository repo) {
        this.repo = repo;
    }

    public List<Eveniment> getAll() {
        return repo.findAll();
    }

    public Optional<Eveniment> getById(Long id) {
        return repo.findById(id);
    }

    public List<Eveniment> getByCategorie(String categorie) {
        return repo.findByCategorie(categorie);
    }

    public List<Eveniment> getByOrganizator(Organizator organizator) {
        return repo.findByOrganizator(organizator);
    }

    public Eveniment save(Eveniment e) {
        return repo.save(e);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}