package com.example.goToTeatro.controller;

import com.example.goToTeatro.entities.Sala;
import com.example.goToTeatro.entities.Utente;
import com.example.goToTeatro.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    SalaRepository salaRepository;

    @PostMapping("/create")
    public void createSala(@RequestBody Sala sala){
        salaRepository.saveAndFlush(sala);
    }
}
