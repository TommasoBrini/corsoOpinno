package com.example.GestionePrenotazioneWebService.controller.api;

import com.example.GestionePrenotazioneWebService.model.Edificio;
import com.example.GestionePrenotazioneWebService.service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class EdificioController {


    @Autowired
    EdificioService cs;

    @GetMapping("/edifici")
    public ResponseEntity<List<Edificio>> getAllCities(){
        List<Edificio> res = cs.getAllEdificio();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/edificio")
    public ResponseEntity<Optional<Edificio>> getEdificioByID(@RequestParam int id){
        Optional<Edificio> res = cs.getEdificioById(id);
        if(res.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/edificio/")
    public ResponseEntity<Edificio> createEdificio(@RequestBody Edificio c){
        Edificio newEdificio = cs.saveEdificio(c);

        return new ResponseEntity<>(newEdificio, HttpStatus.OK);
    }

    @PutMapping("/edificio/")
    public ResponseEntity<Edificio> updateEdificio(@RequestBody Edificio c){
        Edificio newEdificio = cs.updateEdificio(c);

        return new ResponseEntity<>(newEdificio, HttpStatus.OK);
    }

    @DeleteMapping("/edificio/{id}")
    public ResponseEntity<Edificio> deleteEdificio(@PathVariable int id){
        Edificio c = cs.getEdificioById(id).get();
        cs.deleteEdificio(c);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
