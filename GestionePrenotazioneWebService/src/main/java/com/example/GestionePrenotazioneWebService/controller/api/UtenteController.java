package com.example.GestionePrenotazioneWebService.controller.api;

import com.example.GestionePrenotazioneWebService.model.Utente;
import com.example.GestionePrenotazioneWebService.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class UtenteController {

    @Autowired
    UtenteService cs;

    @GetMapping("/utenti")
    public ResponseEntity<List<Utente>> getAllCities(){
        List<Utente> res = cs.getAllUser();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/utente")
    public ResponseEntity<Optional<Utente>> getUtenteByID(@RequestParam int id){
        Optional<Utente> res = cs.getUserById(id);
        if(res.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/utente/")
    public ResponseEntity<Utente> createUtente(@RequestBody Utente c){
        Utente newUtente = cs.saveUser(c);

        return new ResponseEntity<>(newUtente, HttpStatus.OK);
    }

    @PutMapping("/utente/")
    public ResponseEntity<Utente> updateUtente(@RequestBody Utente c){
        Utente newUtente = cs.updateUser(c);

        return new ResponseEntity<>(newUtente, HttpStatus.OK);
    }

    @DeleteMapping("/utente/{id}")
    public ResponseEntity<Utente> deleteUtente(@PathVariable int id){
        Utente c = cs.getUserById(id).get();
        cs.deleteUser(c);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
