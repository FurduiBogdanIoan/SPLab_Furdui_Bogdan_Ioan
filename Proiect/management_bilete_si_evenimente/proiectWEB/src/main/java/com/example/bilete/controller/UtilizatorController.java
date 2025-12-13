package com.example.bilete.controller;

import org.springframework.web.bind.annotation.*;
import com.example.bilete.model.Utilizator;
import com.example.bilete.service.UtilizatorService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilizatori")
@CrossOrigin
public class UtilizatorController {

    private final UtilizatorService service;

    public UtilizatorController(UtilizatorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Utilizator> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Utilizator> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Utilizator create(@RequestBody Utilizator utilizator) {
        return service.save(utilizator);
    }

    @PutMapping("/{id}")
    public Utilizator update(@PathVariable Long id, @RequestBody Utilizator utilizator) {
        utilizator.setId(id);
        return service.save(utilizator);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}