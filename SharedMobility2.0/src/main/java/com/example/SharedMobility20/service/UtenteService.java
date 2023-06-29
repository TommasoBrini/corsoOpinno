package com.example.SharedMobility20.service;

import com.example.SharedMobility20.model.Utente;
import com.example.SharedMobility20.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    UtenteRepository repo;

    public UtenteService(UtenteRepository repo){
        this.repo = repo;
    }

    public Utente saveUtente(Utente ut){
        return repo.save(ut);
    }

    public Utente updateUtente(Utente ut){
        return repo.save(ut);
    }

    public void deleteUtente(Utente ut){
        repo.delete(ut);
    }

    public Optional<Utente> getUtenteById(int id){
        return repo.findById(id);
    }

    public List<Utente> getUtenti(){
        return repo.findAll();
    }
}
