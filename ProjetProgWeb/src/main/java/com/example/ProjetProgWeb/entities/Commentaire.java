package com.example.ProjetProgWeb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@XmlRootElement
public class Commentaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CommentairePK commentairePK;


    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String description;

    @JoinColumn(name = "idAnnonce", referencedColumnName = "idAnnonce", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    //@JsonIgnoreProperties("commantaireList")
    private Annonce annonce;

    @JoinColumn(name = "idPersonne", referencedColumnName = "idPersonne", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    //@JsonIgnoreProperties("commantaireList")
    private Personne personne;

    public Commentaire() {
    }


    public Commentaire(CommentairePK commentairePK, String description) {
        this.commentairePK = commentairePK;
        this.description = description;
    }

    public CommentairePK getCommentairePK() {
        return commentairePK;
    }

    public void setCommentairePK(CommentairePK commentairePK) {
        this.commentairePK = commentairePK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
