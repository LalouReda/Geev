package com.example.ProjetProgWeb.implementations;

import com.example.ProjetProgWeb.entities.Annonce;
import com.example.ProjetProgWeb.entities.Reservation;
import com.example.ProjetProgWeb.entities.ReservationPK;
import com.example.ProjetProgWeb.entities.Statut;
import com.example.ProjetProgWeb.interfaces.IReservation;
import com.example.ProjetProgWeb.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationImpl implements IReservation {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    AnnonceImpl serviceAnnonce;

    @Override
    public Reservation create(long idAnnonce, long idPersonne) {

        Annonce annonce =  serviceAnnonce.find(idAnnonce);
        if (annonce.getStatut().getId() == 1 && annonce.getPersonne().getIdPersonne() != idPersonne){ //id 1 correspond a libre
            annonce.setStatut(serviceAnnonce.getEntityManager().find(Statut.class,Long.parseLong(String.valueOf(2))));  //id 2 correspond a reserver
            ReservationPK reservationPK= new ReservationPK(idPersonne, idAnnonce, new Date());
            Reservation reservation = new Reservation(reservationPK);
            return  reservationRepository.save(reservation);
        }
        else if(annonce.getStatut().getId() == 2){
            if (annonce.getPersonne().getIdPersonne() == idPersonne){
                annonce.setStatut(serviceAnnonce.getEntityManager().find(Statut.class,Long.parseLong(String.valueOf(3))));
                ReservationPK reservationPK= new ReservationPK(idPersonne, idAnnonce, new Date());
                Reservation reservation = new Reservation(reservationPK);
                return  reservationRepository.save(reservation);
            }
            Query query = serviceAnnonce.getEntityManager().createQuery("SELECT r FROM Reservation r WHERE r.reservationPK.idAnnonce = :idAnnonce")
                    .setParameter("idAnnonce", idAnnonce);
            List<Reservation> reservationList = (List<Reservation>) query.getResultList();
            Reservation r = reservationList.get(reservationList.size() - 1);

            if (idPersonne == r.getPersonne().getIdPersonne()){
                annonce.setStatut(serviceAnnonce.getEntityManager().find(Statut.class,Long.parseLong(String.valueOf(1))));
                ReservationPK reservationPK= new ReservationPK(idPersonne, idAnnonce, new Date());
                Reservation reservation = new Reservation(reservationPK);
                return  reservationRepository.save(reservation);
            }
        }
        return null;
    }

    @Override
    public Reservation find(long idAnnonce, long idPersonne, Date date) {
        Query query = serviceAnnonce.getEntityManager().createQuery("SELECT r FROM Reservation r WHERE r.reservationPK.idAnnonce = :idAnnonce AND r.reservationPK.idPersonne = :idPersonne AND r.reservationPK.date = :date")
                .setParameter("idAnnonce", idAnnonce)
                .setParameter("idPersonne", idPersonne)
                .setParameter("date", date);
        return (Reservation) query.getSingleResult();

    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

   /* @Override
    public Optional<Reservation> find(ReservationPK reservationPK) {
        return reservationRepository.findOne(reservationPK);
    }*/

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
