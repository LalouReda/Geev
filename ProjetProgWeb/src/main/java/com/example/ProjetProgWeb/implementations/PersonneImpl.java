package com.example.ProjetProgWeb.implementations;

import com.example.ProjetProgWeb.entities.Personne;
import com.example.ProjetProgWeb.interfaces.IPersonne;
import com.example.ProjetProgWeb.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class PersonneImpl implements IPersonne {

    @Autowired
    PersonneRepository personneRepository;

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Personne create(Personne personne) {
        return personneRepository.save(personne);
    }

    @Override
    public Personne findPersonne(Object login, Object pass) {
        System.out.println("params"+login +" "+pass);
        try {
            Query query = getEntityManager().createQuery("SELECT p FROM Personne p WHERE p.email = :email AND p.password = :password OR p.telephone = :email AND p.password = :password")
                    .setParameter("email", login)
                    .setParameter("password", pass);
            return (Personne) query.getSingleResult();
        }catch (Exception e){
            System.out.println("exception "+e.getMessage());
        }
        return null;
    }

    @Override
    public Personne update(Personne personne) {
        return personneRepository.save(personne);
    }

    @Override
    public void delete(long id) {
        personneRepository.deleteById(id);
    }

    @Override
    public Optional<Personne> find(long id) {
        return personneRepository.findById(id);
    }

    @Override
    public List<Personne> findAll() {
        return personneRepository.findAll();
    }
}
