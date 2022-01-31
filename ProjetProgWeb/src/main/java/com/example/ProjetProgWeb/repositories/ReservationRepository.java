package com.example.ProjetProgWeb.repositories;

import com.example.ProjetProgWeb.entities.Reservation;
import com.example.ProjetProgWeb.entities.ReservationPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationPK> {
}