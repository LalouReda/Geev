package com.example.ProjetProgWeb.implementations;

import com.example.ProjetProgWeb.entities.Annonce;
import com.example.ProjetProgWeb.entities.Personne;
import com.example.ProjetProgWeb.entities.Statut;
import com.example.ProjetProgWeb.interfaces.IAnnonce;
import com.example.ProjetProgWeb.repositories.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class AnnonceImpl implements IAnnonce {

    @Autowired
    AnnonceRepository annonceRepository;

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Annonce create(Annonce annonce) {
        annonce.setStatut(getEntityManager().find(Statut.class, Long.parseLong(String.valueOf(1))));
        annonce.setDate(new Date());
        return annonceRepository.save(annonce);
    }

    @Override
    public Annonce update(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    @Override
    public void delete(long id) {
        annonceRepository.deleteById(id);
    }

    @Override
    public Annonce find(long id) {
        return (Annonce) getEntityManager().find(Annonce.class, id);
    }

    @Override
    public List<Annonce> findAll() {
        return annonceRepository.findAll();
    }
}
