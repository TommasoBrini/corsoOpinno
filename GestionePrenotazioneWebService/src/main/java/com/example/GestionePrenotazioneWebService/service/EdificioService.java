package com.example.GestionePrenotazioneWebService.service;

import com.example.GestionePrenotazioneWebService.model.Edificio;
import com.example.GestionePrenotazioneWebService.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EdificioService {
    @Autowired
    EdificioRepository repo;

    public EdificioService(EdificioRepository repo) {
        this.repo = repo;
    }

    public Edificio saveEdificio(Edificio e){
        return repo.save(e);
    }

    public Edificio updateEdificio(Edificio e){
        return repo.save(e);
    }

    public void deleteEdificio(Edificio e){
        repo.delete(e);
    }

    public Optional<Edificio> getEdificioById(int id){
        return repo.findById(id);
    }

    public List<Edificio> getAllEdificio(){
        return repo.findAll();
    }

}
