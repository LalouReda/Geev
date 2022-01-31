package com.example.ProjetProgWeb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.*;

@Entity
@XmlRootElement
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idPersonne;

    @Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 25)
    @Column(nullable = false, length = 25)
    private String nom;

    @Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 25)
    @Column(nullable = false, length = 25)
    private String prenom;

    @Basic(optional = false)
    @NotNull
    @Size(min = 5, max = 50)
    @Column(nullable = false, length = 50)
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 255)
    @Column(nullable = true, length = 255)
    private String description;

    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 255)
    @Column(nullable = true, length = 255)
    private String password;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = true, length = 255)
    private long telephone;


    @OneToMany(mappedBy = "personne",cascade = CascadeType.ALL,fetch= FetchType.LAZY)
    @JsonIgnoreProperties("personne")
    private List<Annonce> annonceList;

    @OneToMany(mappedBy = "personne",cascade = CascadeType.ALL,fetch= FetchType.LAZY)
    @JsonIgnoreProperties("personne")
    private List<Commentaire> commentaireList;

    @OneToMany(mappedBy = "personne",cascade = CascadeType.ALL,fetch= FetchType.LAZY)
    @JsonIgnoreProperties("personne")
    private List<Reservation> reservationList;

    public Personne() {
    }

    public Personne(long idPersonne, String nom, String prenom, String email, String description, String password, long telephone, List<Annonce> annonceList, List<Commentaire> commentaireList, List<Reservation> reservationList) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.description = description;
        this.password = password;
        this.telephone = telephone;
        this.annonceList = annonceList;
        this.commentaireList = commentaireList;
        this.reservationList = reservationList;
    }

    public long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Annonce> getAnnonceList() {
        return annonceList;
    }

    @XmlTransient
    public void setAnnonceList(List<Annonce> annonceList) {
        this.annonceList = annonceList;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "idPersonne=" + idPersonne +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", password='" + password + '\'' +
                ", telephone=" + telephone +
                ", annonceList=" + annonceList +
                ", commentaireList=" + commentaireList +
                ", reservationList=" + reservationList +
                '}';
    }
}
