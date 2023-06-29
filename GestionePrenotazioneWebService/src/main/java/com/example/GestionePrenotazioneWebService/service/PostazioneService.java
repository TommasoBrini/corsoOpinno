package com.example.GestionePrenotazioneWebService.service;

import com.example.GestionePrenotazioneWebService.model.Postazione;
import com.example.GestionePrenotazioneWebService.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostazioneService {
    @Autowired
    PostazioneRepository repo;

    public PostazioneService(PostazioneRepository repo) {
        this.repo = repo;
    }

    public Postazione savePostazione(Postazione p){
        return repo.save(p);
    }

    public Postazione updatePostazione(Postazione p){
        return repo.save(p);
    }

    public void deletePostazione(Postazione p){
        repo.delete(p);
    }

    public Optional<Postazione> getPostazioneById(int id){
        return repo.findById(id);
    }

    public List<Postazione> getAllPostazione(){
        return repo.findAll();
    }

}
