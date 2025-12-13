package com.example.bilete.repository;

import com.example.bilete.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LocatieRepository extends JpaRepository<Locatie, Long> {
    List<Locatie> findByOras(String oras);
}