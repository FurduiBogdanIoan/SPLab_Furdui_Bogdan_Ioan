package com.example.bilete.repository;

import com.example.bilete.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    List<Comanda> findByUtilizator(Utilizator utilizator);
}