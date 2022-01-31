package com.example.ProjetProgWeb.entities;


import com.example.ProjetProgWeb.entities.Annonce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Statut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String libelle;



    @OneToMany(mappedBy = "statut",cascade = CascadeType.ALL,fetch= FetchType.LAZY)
    @JsonIgnoreProperties("statut")
    private List<Annonce> annonceList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }



    public List<Annonce> getAnnonceList() {
        return annonceList;
    }

    public void setAnnonceList(List<Annonce> annonceList) {
        this.annonceList = annonceList;
    }
}
