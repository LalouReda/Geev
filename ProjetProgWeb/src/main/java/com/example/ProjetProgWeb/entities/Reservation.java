package com.example.ProjetProgWeb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservationPK reservationPK;

    @JoinColumn(name = "idAnnonce", referencedColumnName = "idAnnonce", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    //@JsonIgnoreProperties("reservationList")
    private Annonce annonce;

    @JoinColumn(name = "idPersonne", referencedColumnName = "idPersonne", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    //@JsonIgnoreProperties("reservationList")
    private Personne personne;

    public Reservation() {
    }

    public Reservation(ReservationPK reservationPK) {
        this.reservationPK = reservationPK;

    }

    public ReservationPK getReservationPK() {
        return reservationPK;
    }

    public void setReservationPK(ReservationPK reservationPK) {
        this.reservationPK = reservationPK;
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

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationPK=" + reservationPK +
                ", annonce=" + annonce +
                ", personne=" + personne +
                '}';
    }
}
