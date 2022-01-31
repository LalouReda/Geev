package com.example.ProjetProgWeb.controllers;


import com.example.ProjetProgWeb.entities.Commentaire;
import com.example.ProjetProgWeb.implementations.CommentaireImpl;
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
public class CommentaireController {

    @Autowired
    private CommentaireImpl commentaireService;

    @PostMapping("/commentaire")
    public Commentaire addCommentaire(@RequestBody ObjectNode objectNode) throws Exception{
        int idAnnonce = Integer.parseInt(objectNode.get("idAnnonce").asText());

        int idPersonne = Integer.parseInt(objectNode.get("idPersonne").asText());

        String description = objectNode.get("description").asText();

        return commentaireService.create(idAnnonce,idPersonne,description);
    }

    @DeleteMapping("/commentaire")

    public void deleteCommentaire(@RequestBody ObjectNode objectNode) throws Exception{
        int idAnnonce = Integer.parseInt(objectNode.get("idAnnonce").asText());

        int idPersonne = Integer.parseInt(objectNode.get("idPersonne").asText());

        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(objectNode.get("date").asText());

        commentaireService.delete(commentaireService.find(idAnnonce,idPersonne,date));
    }

    @RequestMapping(value = "/commentaires", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody public List<Commentaire> getAllAnonnces() {
        return commentaireService.findAll();
    }

    @GetMapping("/commentaire")
    public Commentaire getCommentaire(@RequestBody ObjectNode objectNode) throws Exception{
        int idAnnonce = Integer.parseInt(objectNode.get("idAnnonce").asText());

        int idPersonne = Integer.parseInt(objectNode.get("idPersonne").asText());

        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(objectNode.get("date").asText());
        return commentaireService.find(idAnnonce,idPersonne,date);
    }

    @GetMapping("/commentaires/{idAnnonce}")
    public List<Commentaire>  findAllByAnnonceId(@PathVariable(value = "idAnnonce") Long idAnnonce) throws Exception{
        return commentaireService.findAllByAnnonceId(Long.parseLong(String.valueOf(idAnnonce)));
    }



}
