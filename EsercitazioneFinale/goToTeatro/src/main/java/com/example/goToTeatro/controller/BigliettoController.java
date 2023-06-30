package com.example.goToTeatro.controller;

import com.example.goToTeatro.entities.Biglietto;
import com.example.goToTeatro.repository.BigliettoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biglietto")
public class BigliettoController {
    @Autowired
    private BigliettoRepository repo;
    @PostMapping("/create")
    public void createBiglietto(@RequestBody Biglietto biglietto){
        repo.saveAndFlush(biglietto);
    }
}
