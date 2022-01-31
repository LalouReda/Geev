package com.example.ProjetProgWeb.repositories;

import com.example.ProjetProgWeb.entities.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutRepository extends JpaRepository<Statut, Long> {
}