package com.example.ProjetProgWeb.repositories;

import com.example.ProjetProgWeb.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
}