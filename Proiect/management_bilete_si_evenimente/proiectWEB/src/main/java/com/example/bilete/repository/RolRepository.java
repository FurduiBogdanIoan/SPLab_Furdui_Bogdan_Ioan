package com.example.bilete.repository;

import com.example.bilete.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNume(String nume);
}