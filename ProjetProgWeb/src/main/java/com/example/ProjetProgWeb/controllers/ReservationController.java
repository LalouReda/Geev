package com.example.ProjetProgWeb.controllers;

import com.example.ProjetProgWeb.entities.Reservation;
import com.example.ProjetProgWeb.entities.ReservationPK;
import com.example.ProjetProgWeb.implementations.ReservationImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ReservationController {

    @Autowired
    private ReservationImpl reservationService;

    @PostMapping("/reservation")
    public Reservation addReservation(@RequestBody ObjectNode objectNode) throws Exception{
        int idAnnonce = Integer.parseInt(objectNode.get("idAnnonce").asText());

        int idPersonne = Integer.parseInt(objectNode.get("idPersonne").asText());

        return reservationService.create(idAnnonce,idPersonne);
    }

    @GetMapping("/reservation")
    public Reservation getReservation(@RequestBody ObjectNode objectNode) throws Exception{
        int idAnnonce = Integer.parseInt(objectNode.get("idAnnonce").asText());

        int idPersonne = Integer.parseInt(objectNode.get("idPersonne").asText());

        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(objectNode.get("date").asText());
        return reservationService.find(idAnnonce,idPersonne,date);
    }



    @DeleteMapping("/reservation")

    public void deleteReservation(@RequestBody ObjectNode objectNode) throws Exception{
        int idAnnonce = Integer.parseInt(objectNode.get("idAnnonce").asText());

        int idPersonne = Integer.parseInt(objectNode.get("idPersonne").asText());

        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(objectNode.get("date").asText());

        reservationService.delete(reservationService.find(idAnnonce,idPersonne,date));
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody public List<Reservation> getAllAnonnces() {
        return reservationService.findAll();
    }
}
