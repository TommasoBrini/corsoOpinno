package com.example.SharedMobility20.service;

import com.example.SharedMobility20.model.Veicolo;
import com.example.SharedMobility20.repository.VeicoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeicoloService {
    @Autowired
    VeicoloRepository repo;

    public VeicoloService(VeicoloRepository repo){
        this.repo = repo;
    }

    public Veicolo saveVeicolo(Veicolo ve){
        return repo.save(ve);
    }

    public Veicolo updateVeicolo(Veicolo ve){
        return repo.save(ve);
    }

    public void deleteVeicolo(Veicolo ve){
        repo.delete(ve);
    }

    public Optional<Veicolo> getVeicoloById(int id){
        return repo.findById(id);
    }

    public List<Veicolo> getVeicoli(){
        return repo.findAll();
    }
}
