package com.example.bilete.controller;

import org.springframework.web.bind.annotation.*;
import com.example.bilete.model.TipBilet;
import com.example.bilete.service.TipBiletService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipuri-bilet")
@CrossOrigin
public class TipBiletController {

    private final TipBiletService service;

    public TipBiletController(TipBiletService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipBilet> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TipBilet> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public TipBilet create(@RequestBody TipBilet tipBilet) {
        return service.save(tipBilet);
    }

    @PutMapping("/{id}")
    public TipBilet update(@PathVariable Long id, @RequestBody TipBilet tipBilet) {
        tipBilet.setId(id);
        return service.save(tipBilet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}