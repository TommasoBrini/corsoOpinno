package com.example.GestionePrenotazioneWebService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String nome;
    private String email;
    private String password;

    public Utente(){}

    public Utente(String username, String nome, String email, String password) {
        this(null, username, nome, email,password);
    }
}
