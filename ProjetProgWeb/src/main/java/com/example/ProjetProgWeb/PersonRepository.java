package com.example.ProjetProgWeb;

import com.example.ProjetProgWeb.entities.Personne;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Personne, String> {

}
