package com.example.ProjetProgWeb.interfaces;

import com.example.ProjetProgWeb.entities.Personne;

import java.util.List;
import java.util.Optional;

public interface IPersonne {

    Personne create(Personne personne);

    Personne findPersonne(Object login, Object pass);

    Personne update(Personne personne);
    void delete(long id);
    Optional<Personne> find(long id);
    List<Personne> findAll();
}
