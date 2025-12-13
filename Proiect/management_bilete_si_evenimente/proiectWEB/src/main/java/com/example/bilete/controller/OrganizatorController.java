package com.example.bilete.controller;

import org.springframework.web.bind.annotation.*;

import com.example.bilete.model.Organizator;
import com.example.bilete.service.OrganizatorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organizatori")
@CrossOrigin
public class OrganizatorController {

    private final OrganizatorService service;

    public OrganizatorController(OrganizatorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Organizator> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Organizator> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Organizator create(@RequestBody Organizator organizator) {
        return service.save(organizator);
    }

    @PutMapping("/{id}")
    public Organizator update(@PathVariable Long id, @RequestBody Organizator organizator) {
        organizator.setId(id);
        return service.save(organizator);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}