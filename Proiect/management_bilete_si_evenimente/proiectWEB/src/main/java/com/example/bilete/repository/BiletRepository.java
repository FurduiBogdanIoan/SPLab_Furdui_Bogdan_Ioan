package com.example.bilete.repository;

import com.example.bilete.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BiletRepository extends JpaRepository<Bilet, Long> {
    List<Bilet> findByComanda(Comanda comanda);
    Optional<Bilet> findByCodUnic(String codUnic);
}