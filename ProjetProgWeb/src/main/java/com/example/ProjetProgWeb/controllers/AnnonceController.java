package com.example.ProjetProgWeb.controllers;

import com.example.ProjetProgWeb.entities.Annonce;
import com.example.ProjetProgWeb.entities.Personne;
import com.example.ProjetProgWeb.entities.Reservation;
import com.example.ProjetProgWeb.entities.Statut;
import com.example.ProjetProgWeb.implementations.AnnonceImpl;
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
public class AnnonceController {

    @Autowired
    private AnnonceImpl annonceService;

    @Autowired
    ReservationImpl serviceReservation;

    @PostMapping("/annonce")
    public Annonce addAnnonce(@RequestBody ObjectNode objectNode) throws Exception{
        Long idPersonne = Long.valueOf((objectNode.get("idPersonne").asText()));
        String title = objectNode.get("title").asText();
        String description = objectNode.get("description").asText();
        String image = objectNode.get("image").asText();
        String adresseDeRecuperation = objectNode.get("adresseDeRecuperation").asText();

        Annonce annonce= new Annonce(title,
                description,
                adresseDeRecuperation,
                image,
                annonceService.getEntityManager().find(Personne.class,idPersonne));

        return annonceService.create(annonce);
    }

    @GetMapping("/annonce/{id}")
    public Annonce getAnnonce(@PathVariable(value = "id") long id){
        return annonceService.find(id);
    }

    @PutMapping("/annonce")
    public Annonce updateAnnonce(@RequestBody Annonce Annonce) throws Exception{
        return annonceService.update(Annonce);
    }

    @PutMapping("/confirmer")
    public Annonce confirmerReservation(@RequestBody ObjectNode objectNode) throws Exception{

        String stringDate = objectNode.get("date").asText();
        String[] da = stringDate.split("-");

        int idAnnonce = Integer.parseInt(objectNode.get("idAnnonce").asText());

        int idPersonne = Integer.parseInt(objectNode.get("idPersonne").asText());

        Date date = new SimpleDateFormat("yyyy/MM/dd").parse(da[0]+"/"+da[1]+"/"+da[2]);

        Reservation reservation = serviceReservation.find(idAnnonce,idPersonne, date);
        Annonce annonce = reservation.getAnnonce();
        if (annonce.getStatut().getId() == 2){
            annonce.setStatut(annonceService.getEntityManager().find(Statut.class,Long.parseLong(String.valueOf(3))));
            return annonceService.update((annonce));
        }
        return null;
    }

    @DeleteMapping("/annonce/{id}")
    public void deleteAnnonce(@PathVariable(value = "id") long id){
        annonceService.delete(id);
    }

    @RequestMapping(value = "/annonces", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody public List<Annonce> getAllAnonnces() {
        return annonceService.findAll();
    }

}