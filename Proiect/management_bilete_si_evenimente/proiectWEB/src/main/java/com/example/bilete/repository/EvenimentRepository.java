package com.example.bilete.repository;

import com.example.bilete.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvenimentRepository extends JpaRepository<Eveniment, Long> {
    List<Eveniment> findByCategorie(String categorie);
    List<Eveniment> findByOrganizator(Organizator organizator);
}