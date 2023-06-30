package com.example.goToTeatro.controller;

import com.example.goToTeatro.entities.Posto;
import com.example.goToTeatro.entities.Spettacolo;
import com.example.goToTeatro.repository.PostoRepository;
import com.example.goToTeatro.repository.SpettacoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spettacolo")
public class SpettacoloController {
    @Autowired
    private SpettacoloRepository spettacoloRepository;

    @PostMapping("/create")
    public void createSpettacolo(@RequestBody Spettacolo spettacolo){
        spettacoloRepository.saveAndFlush(spettacolo);
    }
}


