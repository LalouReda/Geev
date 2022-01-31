package com.example.ProjetProgWeb.repositories;

import com.example.ProjetProgWeb.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}