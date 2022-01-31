package com.example.ProjetProgWeb.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ReservationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idPersonne;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private long idAnnonce;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    public ReservationPK() {
    }

    public ReservationPK(long idPersonne, long idAnnonce, Date date) {
        this.idPersonne = idPersonne;
        this.idAnnonce = idAnnonce;
        this.date = date;
    }

    public long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public long getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(long idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}