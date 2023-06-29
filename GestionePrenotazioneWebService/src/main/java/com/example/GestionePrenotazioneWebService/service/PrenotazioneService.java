package com.example.GestionePrenotazioneWebService.service;

import com.example.GestionePrenotazioneWebService.model.Prenotazione;
import com.example.GestionePrenotazioneWebService.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository repo;

    public PrenotazioneService(PrenotazioneRepository repo) {
        this.repo = repo;
    }

    public Prenotazione savePrenotazione(Prenotazione p){
        return repo.save(p);
    }

    public Prenotazione updatePrenotazione(Prenotazione p){
        return repo.save(p);
    }

    public void deletePrenotazione(Prenotazione p){
        repo.delete(p);
    }

    public Optional<Prenotazione> getPrenotazioneById(int id){
        return repo.findById(id);
    }

    public List<Prenotazione> getAllPrenotazione(){
        return repo.findAll();
    }

}
