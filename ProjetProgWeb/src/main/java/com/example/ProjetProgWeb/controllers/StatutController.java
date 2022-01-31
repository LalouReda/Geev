package com.example.ProjetProgWeb.controllers;

import com.example.ProjetProgWeb.entities.Statut;
import com.example.ProjetProgWeb.implementations.StatutImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class StatutController {

    @Autowired
    private StatutImpl statutService;

    @PostMapping("/statut")
    public Statut addStatut(@RequestBody Statut Statut) throws Exception{
        return statutService.create(Statut);
    }

    @GetMapping("/statut/{id}")
    public Optional<Statut> getStatut(@PathVariable(value = "id") long id){
        return statutService.find(id);
    }

    @PutMapping("/statut")
    public Statut updateStatut(@RequestBody Statut Statut) throws Exception{
        return statutService.update(Statut);
    }

    @DeleteMapping("/statut/{id}")
    public void deleteStatut(@PathVariable(value = "id") long id){
        statutService.delete(id);
    }

    @RequestMapping(value = "/statuts", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody public List<Statut> getAllStatuts() {
        return statutService.findAll();
    }
}
