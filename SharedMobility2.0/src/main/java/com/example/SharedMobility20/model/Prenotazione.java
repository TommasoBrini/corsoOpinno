package com.example.SharedMobility20.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@Data
public class Prenotazione {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private Timestamp Timestamp;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private Veicolo veicolo;

    public Prenotazione(){

    }

    public Prenotazione(Timestamp timestamp, Utente utente, Veicolo veicolo) {
        this(null, timestamp,utente,veicolo);
    }
}
