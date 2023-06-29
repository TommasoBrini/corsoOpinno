package com.example.GestionePrenotazioneWebService.service;

import com.example.GestionePrenotazioneWebService.model.Utente;
import com.example.GestionePrenotazioneWebService.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    UtenteRepository repo;

    public UtenteService(UtenteRepository repo) {
        this.repo = repo;
    }

    public Utente saveUser(Utente u){
        return repo.save(u);
    }

    public Utente updateUser(Utente u){
        return repo.save(u);
    }

    public void deleteUser(Utente u){
        repo.delete(u);
    }

    public Optional<Utente> getUserById(int id){
        return repo.findById(id);
    }

    public List<Utente> getAllUser(){
        return repo.findAll();
    }

}
