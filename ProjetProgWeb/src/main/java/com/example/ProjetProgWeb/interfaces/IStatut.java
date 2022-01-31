package com.example.ProjetProgWeb.interfaces;

import com.example.ProjetProgWeb.entities.Statut;

import java.util.List;
import java.util.Optional;

public interface IStatut {

    Statut create(Statut statut);
    Statut update(Statut statut);
    void delete(long id);
    Optional<Statut> find(long id);
    List<Statut> findAll();
}
