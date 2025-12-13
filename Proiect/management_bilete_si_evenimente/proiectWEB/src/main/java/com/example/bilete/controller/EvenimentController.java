package com.example.bilete.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.bilete.model.Eveniment;
import com.example.bilete.service.EvenimentService;
import com.example.bilete.service.FileStorageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evenimente")
@CrossOrigin
public class EvenimentController {

    private final EvenimentService evenimentService;
    private final FileStorageService fileStorageService;

    public EvenimentController(EvenimentService evenimentService, FileStorageService fileStorageService) {
        this.evenimentService = evenimentService;
        this.fileStorageService = fileStorageService;
    }

    @GetMapping
    public List<Eveniment> getAll() {
        return evenimentService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Eveniment> getById(@PathVariable Long id) {
        return evenimentService.getById(id);
    }

    @GetMapping("/categorie/{categorie}")
    public List<Eveniment> getByCategorie(@PathVariable String categorie) {
        return evenimentService.getByCategorie(categorie);
    }

    @PostMapping
    public Eveniment create(@RequestBody Eveniment eveniment) {
        return evenimentService.save(eveniment);
    }

    @PutMapping("/{id}")
    public Eveniment update(@PathVariable Long id, @RequestBody Eveniment eveniment) {
        eveniment.setId(id);
        return evenimentService.save(eveniment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        evenimentService.delete(id);
    }

    @PostMapping("/{id}/upload-imagine")
    public ResponseEntity<String> uploadImagine(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file
    ) {
        Eveniment eveniment = evenimentService.getById(id)
                .orElseThrow(() -> new RuntimeException("Evenimentul nu există"));

        String url = fileStorageService.storeFile(file);
        eveniment.setImagineUrl(url);
        evenimentService.save(eveniment);

        return ResponseEntity.ok(url);
    }
}
