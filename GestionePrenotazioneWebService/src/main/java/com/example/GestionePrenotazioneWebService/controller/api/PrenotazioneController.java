package com.example.GestionePrenotazioneWebService.controller.api;

import com.example.GestionePrenotazioneWebService.model.Prenotazione;
import com.example.GestionePrenotazioneWebService.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class PrenotazioneController {

    @Autowired
    PrenotazioneService cs;

    @GetMapping("/prenotazioni")
    public ResponseEntity<List<Prenotazione>> getAllCities(){
        List<Prenotazione> res = cs.getAllPrenotazione();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/prenotazione")
    public ResponseEntity<Optional<Prenotazione>> getPrenotazioneByID(@RequestParam int id){
        Optional<Prenotazione> res = cs.getPrenotazioneById(id);
        if(res.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/prenotazione/")
    public ResponseEntity<Prenotazione> createPrenotazione(@RequestBody Prenotazione c){
        Prenotazione newPrenotazione = cs.savePrenotazione(c);

        return new ResponseEntity<>(newPrenotazione, HttpStatus.OK);
    }

    @PutMapping("/prenotazione/")
    public ResponseEntity<Prenotazione> updatePrenotazione(@RequestBody Prenotazione c){
        Prenotazione newPrenotazione = cs.updatePrenotazione(c);

        return new ResponseEntity<>(newPrenotazione, HttpStatus.OK);
    }

    @DeleteMapping("/prenotazione/{id}")
    public ResponseEntity<Prenotazione> deletePrenotazione(@PathVariable int id){
        Prenotazione c = cs.getPrenotazioneById(id).get();
        cs.deletePrenotazione(c);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
