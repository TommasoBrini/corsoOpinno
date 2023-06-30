package com.example.goToTeatro.controller;

import com.example.goToTeatro.entities.Posto;
import com.example.goToTeatro.entities.Sede;
import com.example.goToTeatro.repository.PostoRepository;
import com.example.goToTeatro.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sede")
public class SedeController {

    @Autowired
    private SedeRepository sedeRepository;

    @PostMapping("/create")
    public void createSede(@RequestBody Sede sede){
        sedeRepository.saveAndFlush(sede);
    }
}
