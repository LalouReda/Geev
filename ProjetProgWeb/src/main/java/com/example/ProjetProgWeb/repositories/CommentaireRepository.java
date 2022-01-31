package com.example.ProjetProgWeb.repositories;

import com.example.ProjetProgWeb.entities.Commentaire;
import com.example.ProjetProgWeb.entities.CommentairePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire, CommentairePK> {
}