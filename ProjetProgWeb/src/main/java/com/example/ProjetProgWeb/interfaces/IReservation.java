package com.example.ProjetProgWeb.interfaces;

import com.example.ProjetProgWeb.entities.Reservation;
import com.example.ProjetProgWeb.entities.ReservationPK;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface IReservation {
    Reservation create(long idAnnonce, long idPersonne);

    Reservation find(long idAnnonce, long idPersonne, Date date);


    void delete(Reservation reservation);
    //Optional<Reservation> findOne(ReservationPK reservationPK);
    List<Reservation> findAll();
}

