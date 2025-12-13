package com.example.bilete.controller;

import org.springframework.web.bind.annotation.*;
import com.example.bilete.model.Locatie;
import com.example.bilete.service.LocatieService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locatii")
@CrossOrigin
public class LocatieController {

    private final LocatieService service;

    public LocatieController(LocatieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Locatie> getAll() {
        return service.getAll();
    }

    @GetMapping("/oras/{oras}")
    public List<Locatie> getByOras(@PathVariable String oras) {
        return service.getByOras(oras);
    }

    @GetMapping("/{id}")
    public Optional<Locatie> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Locatie create(@RequestBody Locatie locatie) {
        return service.save(locatie);
    }

    @PutMapping("/{id}")
    public Locatie update(@PathVariable Long id, @RequestBody Locatie locatie) {
        locatie.setId(id);
        return service.save(locatie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}