package com.example.SharedMobility20.service;

import com.example.SharedMobility20.model.Prenotazione;
import com.example.SharedMobility20.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository repo;

    public PrenotazioneService(PrenotazioneRepository repo){
        this.repo = repo;
    }

    public Prenotazione savePrenotazione(Prenotazione pr){
        return repo.save(pr);
    }

    public Prenotazione updatePrenotazione(Prenotazione pr){
        return repo.save(pr);
    }

    public void deletePrenotazione(Prenotazione pr){
        repo.delete(pr);
    }

    public Optional<Prenotazione> getPrenotazioneById(int id){
        return repo.findById(id);
    }

    public List<Prenotazione> getPrenotazioni(){
        return repo.findAll();
    }
}
