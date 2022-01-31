package com.example.ProjetProgWeb.implementations;

import com.example.ProjetProgWeb.entities.Statut;
import com.example.ProjetProgWeb.interfaces.IStatut;
import com.example.ProjetProgWeb.repositories.StatutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatutImpl implements IStatut {

    @Autowired
    StatutRepository statutRepository;

    @Override
    public Statut create(Statut statut) {
        return statutRepository.save(statut);
    }

    @Override
    public Statut update(Statut statut) {
        return statutRepository.save(statut);
    }

    @Override
    public void delete(long id) {
        statutRepository.deleteById(id);
    }

    @Override
    public Optional<Statut> find(long id) {
        return statutRepository.findById(id);
    }

    @Override
    public List<Statut> findAll() {
        return statutRepository.findAll();
    }
}
