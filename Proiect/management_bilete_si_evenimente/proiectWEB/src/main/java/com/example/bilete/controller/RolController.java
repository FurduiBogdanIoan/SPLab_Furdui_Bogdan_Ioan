package com.example.bilete.controller;

import org.springframework.web.bind.annotation.*;
import com.example.bilete.model.Rol;
import com.example.bilete.service.RolService;
import java.util.List;

@RestController
@RequestMapping("/api/roluri")
@CrossOrigin
public class RolController {

    private final RolService service;

    public RolController(RolService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rol> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Rol create(@RequestBody Rol rol) {
        return service.save(rol);
    }
}