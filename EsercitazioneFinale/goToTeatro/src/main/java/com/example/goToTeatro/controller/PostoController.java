package com.example.goToTeatro.controller;

import com.example.goToTeatro.entities.Posto;
import com.example.goToTeatro.entities.Utente;
import com.example.goToTeatro.repository.PostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posto")
public class PostoController {
    @Autowired
    private PostoRepository postoRepository;

    @PostMapping("/create")
    public void createPosto(@RequestBody Posto posto){
        postoRepository.saveAndFlush(posto);
    }
}
