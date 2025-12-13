package com.example.bilete.repository;

import com.example.bilete.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TipBiletRepository extends JpaRepository<TipBilet, Long> {
    List<TipBilet> findByEveniment(Eveniment eveniment);
}