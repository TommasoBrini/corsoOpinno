package com.example.GestionePrenotazioneWebService.controller.api;

import com.example.GestionePrenotazioneWebService.model.Postazione;
import com.example.GestionePrenotazioneWebService.service.PostazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class PostazioneController {

    @Autowired
    PostazioneService cs;

    @GetMapping("/cities")
    public ResponseEntity<List<Postazione>> getAllCities(){
        List<Postazione> res = cs.getAllPostazione();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/Postazione")
    public ResponseEntity<Optional<Postazione>> getPostazioneByID(@RequestParam int id){
        Optional<Postazione> res = cs.getPostazioneById(id);
        if(res.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/postazione/")
    public ResponseEntity<Postazione> createPostazione(@RequestBody Postazione c){
        Postazione newPostazione = cs.savePostazione(c);

        return new ResponseEntity<>(newPostazione, HttpStatus.OK);
    }

    @PutMapping("/postazione/")
    public ResponseEntity<Postazione> updatePostazione(@RequestBody Postazione c){
        Postazione newPostazione = cs.updatePostazione(c);

        return new ResponseEntity<>(newPostazione, HttpStatus.OK);
    }

    @DeleteMapping("/postazione/{id}")
    public ResponseEntity<Postazione> deletePostazione(@PathVariable int id){
        Postazione c = cs.getPostazioneById(id).get();
        cs.deletePostazione(c);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
