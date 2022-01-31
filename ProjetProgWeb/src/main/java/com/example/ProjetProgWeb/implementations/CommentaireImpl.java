package com.example.ProjetProgWeb.implementations;


import com.example.ProjetProgWeb.entities.*;
import com.example.ProjetProgWeb.interfaces.ICommentaire;
import com.example.ProjetProgWeb.repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class CommentaireImpl implements ICommentaire {

    @Autowired
    CommentaireRepository commentaireRepository;

    @Autowired
    AnnonceImpl serviceAnnonce;

    @Override
    public Commentaire create(long idAnnonce, long idPersonne, String description) {

        CommentairePK commentairePK = new CommentairePK(idPersonne, idAnnonce, new Date());

        Commentaire commentaire = new Commentaire(commentairePK, description);

        return commentaireRepository.save(commentaire);

    }

    @Override
    public Commentaire find(long idAnnonce, long idPersonne, Date date) {
        Query query = serviceAnnonce.getEntityManager().createQuery("SELECT r FROM Commentaire r WHERE r.commentairePK.idAnnonce = :idAnnonce AND r.commentairePK.idPersonne = :idPersonne AND r.commentairePK.date = :date")
                .setParameter("idAnnonce", idAnnonce)
                .setParameter("idPersonne", idPersonne)
                .setParameter("date", date);
        return (Commentaire) query.getSingleResult();

    }


    @Override
    public List<Commentaire> findAll() {
        return commentaireRepository.findAll();
    }

    @Override
    public List<Commentaire> findAllByAnnonceId(Long idAnnonce) {
        Query query = serviceAnnonce.getEntityManager().createQuery("SELECT c FROM Commentaire c WHERE c.commentairePK.idAnnonce = :idAnnonce")
                .setParameter("idAnnonce", idAnnonce);
        return (List<Commentaire>) query.getResultList();
    }

    @Override
    public void delete(Commentaire commentaire) {
        commentaireRepository.delete(commentaire);
    }




}
