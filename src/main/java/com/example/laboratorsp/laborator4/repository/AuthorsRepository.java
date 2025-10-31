package com.example.laboratorsp.laborator4.repository;

import com.example.laboratorsp.laborator4.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Autor, Long> { }