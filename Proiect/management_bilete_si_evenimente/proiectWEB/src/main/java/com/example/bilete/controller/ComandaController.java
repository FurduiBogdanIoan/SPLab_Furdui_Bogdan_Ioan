package com.example.bilete.controller;

import org.springframework.web.bind.annotation.*;
import com.example.bilete.model.Comanda;
import com.example.bilete.service.ComandaService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comenzi")
@CrossOrigin
public class ComandaController {

    private final ComandaService service;

    public ComandaController(ComandaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Comanda> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Comanda> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Comanda create(@RequestBody Comanda comanda) {
        return service.save(comanda);
    }

    @PutMapping("/{id}")
    public Comanda update(@PathVariable Long id, @RequestBody Comanda comanda) {
        comanda.setId(id);
        return service.save(comanda);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}