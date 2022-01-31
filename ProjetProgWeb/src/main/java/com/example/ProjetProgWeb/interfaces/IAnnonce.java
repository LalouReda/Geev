package com.example.ProjetProgWeb.interfaces;

import com.example.ProjetProgWeb.entities.Annonce;

import java.util.List;
import java.util.Optional;


public interface IAnnonce {
    Annonce create(Annonce annonce);
    Annonce update(Annonce annonce);
    void delete(long id);
    Annonce find(long id);
    List<Annonce> findAll();
}

