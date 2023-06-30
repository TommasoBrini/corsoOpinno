package com.example.goToTeatro.controller;

import com.example.goToTeatro.entities.Utente;
import com.example.goToTeatro.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteRepository repo;

    @PostMapping("/create")
    public void createUser(@RequestBody Utente utente){
        repo.saveAndFlush(utente);
    }

    @GetMapping("/get")
    public Utente getUtenteById(@RequestParam long id){
        Optional<Utente> opUtente = repo.findById(id);
        if (opUtente.isEmpty()) throw new IllegalArgumentException("L'utente con id=" + id + " non esiste");
        return opUtente.get();
    }

    @GetMapping("/getall")
    public List<Utente> getAllUtenti(){
        return repo.findAll();
    }

    @PutMapping("/update")
    public void updateUtente(@RequestParam long id, @RequestParam String email){
        Optional<Utente> opUtente = repo.findById(id);
        if (opUtente.isEmpty()) throw new IllegalArgumentException("L'utente con id=" + id + " non esiste");
        Utente u = opUtente.get();
        u.setEmail(email);
        repo.saveAndFlush(u);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam long id){
        repo.deleteById(id);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll(){
        repo.deleteAll();
    }
}
