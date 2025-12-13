package com.example.bilete.repository;

import com.example.bilete.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UtilizatorRepository extends JpaRepository<Utilizator, Long> {
    Optional<Utilizator> findByEmail(String email);
    boolean existsByEmail(String email);
}