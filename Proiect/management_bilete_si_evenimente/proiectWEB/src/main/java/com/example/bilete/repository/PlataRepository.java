package com.example.bilete.repository;

import com.example.bilete.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PlataRepository extends JpaRepository<Plata, Long> {
    Optional<Plata> findByComanda(Comanda comanda);
}