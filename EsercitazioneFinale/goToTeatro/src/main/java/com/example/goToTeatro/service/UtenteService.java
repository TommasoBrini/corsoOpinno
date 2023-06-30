package com.example.goToTeatro.service;

import com.example.goToTeatro.entities.Biglietto;
import com.example.goToTeatro.entities.Posto;
import com.example.goToTeatro.entities.Spettacolo;
import com.example.goToTeatro.entities.Utente;
import com.example.goToTeatro.repository.BigliettoRepository;
import com.example.goToTeatro.repository.PostoRepository;
import com.example.goToTeatro.repository.SpettacoloRepository;
import com.example.goToTeatro.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private BigliettoRepository bigliettoRepository;

    @Autowired
    private SpettacoloRepository spettacoloRepository;

    @Autowired
    private PostoRepository postoRepository;

    public void buyTicket(@RequestParam long id_u, @RequestParam long id_s, @RequestParam long id_p){

        //Controllo se l'utente con id_u sia presente sul db
        Optional<Utente> opUtente = utenteRepository.findById(id_u);
        if (opUtente.isEmpty()) throw new IllegalArgumentException("L'utente con id=" + id_u + " non esiste");
        Utente u = opUtente.get();

        //Controllo se lo spettacolo con id_s sia presente sul db
        Optional<Spettacolo> opSpettacolo = spettacoloRepository.findById(id_s);
        if(opSpettacolo.isEmpty()) throw new IllegalArgumentException("Lo spettacolo con id=" + id_s + " non esiste");
        Spettacolo s = opSpettacolo.get();

        //Controllo se lo spettacolo con id_s sia presente sul db
        Optional<Posto> opPosto = postoRepository.findById(id_p);
        if(opPosto.isEmpty()) throw new IllegalArgumentException("Il posto con id=" + id_p + " non esiste");
        Posto p = opPosto.get();

        //controllo che lo spettacolo non sia nel passato
        if(s.getOrario().isBefore(LocalDateTime.now())) throw new IllegalArgumentException("non puoi prenotare uno spettacolo passato");

        //controllo che il biglietto non sia già stato acquistato
        if (bigliettoRepository.checkBigliettoBooked(id_p, id_s).size() > 0) throw new IllegalArgumentException("il posto per quello spettacolo è già stato comprato");

        Biglietto b = new Biglietto(LocalDateTime.now(), u, s, p);
        bigliettoRepository.saveAndFlush(b);
        System.out.println("Biglietto acquistato!");
    }
}
