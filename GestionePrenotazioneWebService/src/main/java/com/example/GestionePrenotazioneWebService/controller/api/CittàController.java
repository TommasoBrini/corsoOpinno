package com.example.GestionePrenotazioneWebService.controller.api;

import com.example.GestionePrenotazioneWebService.model.Città;
import com.example.GestionePrenotazioneWebService.service.CittàService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class CittàController {

    @Autowired
    CittàService cs;

    @GetMapping("/cities")
    public ResponseEntity<List<Città>> getAllCities(){
        List<Città> res = cs.getAllCity();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/city")
    public ResponseEntity<Optional<Città>> getCityByID(@RequestParam int id){
        Optional<Città> res = cs.getCityById(id);
        if(res.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/city/")
    public ResponseEntity<Città> createCity(@RequestBody Città c){
        Città newCitta = cs.saveCity(c);

        return new ResponseEntity<>(newCitta, HttpStatus.OK);
    }

    @PutMapping("/city/")
    public ResponseEntity<Città> updateCity(@RequestBody Città c){
        Città newCitta = cs.updateCity(c);

        return new ResponseEntity<>(newCitta, HttpStatus.OK);
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity<Città> deleteCitta(@PathVariable int id){
        Città c = cs.getCityById(id).get();
        cs.deleteCity(c);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
