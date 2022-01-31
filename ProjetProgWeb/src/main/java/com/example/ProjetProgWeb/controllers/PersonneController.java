package com.example.ProjetProgWeb.controllers;

import com.example.ProjetProgWeb.entities.Personne;
import com.example.ProjetProgWeb.implementations.PersonneImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class PersonneController {

    @Autowired
    private PersonneImpl personneService;

    @PostMapping("/personne")
    public Personne addPersonne(@RequestBody Personne Personne) throws Exception{
        return personneService.create(Personne);
    }



    @PostMapping("/login")
    public Personne findPersonne(@RequestBody Personne personne){
        System.out.println("para "+ personne);
        String login = "";
        if (personne.getEmail() != ""){
            login = personne.getEmail();
        }
        if (personne.getTelephone() != 0){
            login = String.valueOf(personne.getTelephone());
        }
        return personneService.findPersonne(login, personne.getPassword());
    }

    @GetMapping("/personne/{id}")
    public Optional<Personne> getPersonne(@PathVariable(value = "id") long id){
        return personneService.find(id);
    }

    @PutMapping("/personne")
    public Personne updatePersonne(@RequestBody Personne Personne) throws Exception{
        return personneService.update(Personne);
    }

    @DeleteMapping("/personne/{id}")
    public void deletePersonne(@PathVariable(value = "id") long id){
        personneService.delete(id);
    }

    @RequestMapping(value = "/personnes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody public List<Personne> getAllPersonnes() {
        return personneService.findAll();
    }
}
