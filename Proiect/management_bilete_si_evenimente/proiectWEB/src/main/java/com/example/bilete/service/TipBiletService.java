package com.example.bilete.service;

import org.springframework.stereotype.Service;

import com.example.bilete.model.Eveniment;
import com.example.bilete.model.TipBilet;
import com.example.bilete.repository.TipBiletRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipBiletService {

    private final TipBiletRepository repo;

    public TipBiletService(TipBiletRepository repo) {
        this.repo = repo;
    }

    public List<TipBilet> getAll() {
        return repo.findAll();
    }

    public Optional<TipBilet> getById(Long id) {
        return repo.findById(id);
    }

    public List<TipBilet> getByEveniment(Eveniment eveniment) {
        return repo.findByEveniment(eveniment);
    }

    public TipBilet save(TipBilet tb) {
        return repo.save(tb);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}