package com.example.ProjetProgWeb.interfaces;

import com.example.ProjetProgWeb.entities.Commentaire;

import java.util.Date;
import java.util.List;

public interface ICommentaire {

    Commentaire create(long idAnnonce, long idPersonne, String description);
    void delete(Commentaire commentaire);
    Commentaire find(long idAnnonce, long idPersonne, Date date);
    List<Commentaire> findAll();
    List<Commentaire> findAllByAnnonceId(Long idAnnonce);
}
