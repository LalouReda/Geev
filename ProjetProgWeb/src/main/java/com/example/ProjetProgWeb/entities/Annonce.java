package com.example.ProjetProgWeb.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long idAnnonce;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String title;

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String adresseDeRecuperation;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String image;

    @ManyToOne
    @JsonIgnoreProperties("annonceList")
    private Personne personne;

    @ManyToOne()
    @JsonIgnoreProperties("annonceList")
    private Statut statut;

    @OneToMany(mappedBy = "annonce",cascade = CascadeType.ALL,fetch= FetchType.LAZY)
    @JsonIgnoreProperties("annonce")
    private List<Commentaire> commentaireList;

    @OneToMany(mappedBy = "annonce",cascade = CascadeType.ALL,fetch= FetchType.LAZY)
    @JsonIgnoreProperties("annonce")
    private List<Reservation> reservationList;

    public Annonce() {
    }

    public Annonce(String title, String description, String adresseDeRecuperation, String image, Personne personne) {
        this.title = title;
        this.description = description;
        this.adresseDeRecuperation = adresseDeRecuperation;
        this.image = image;
        this.personne = personne;
    }

    public Long getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Long idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAdresseDeRecuperation() {
        return adresseDeRecuperation;
    }

    public void setAdresseDeRecuperation(String adresseDeRecuperation) {
        this.adresseDeRecuperation = adresseDeRecuperation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "idAnnonce=" + idAnnonce +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", adresseDeRecuperation='" + adresseDeRecuperation + '\'' +
                ", image='" + image + '\'' +
                ", personne=" + personne +
                ", statut=" + statut +
                ", commentaireList=" + commentaireList +
                ", reservationList=" + reservationList +
                '}';
    }
}
