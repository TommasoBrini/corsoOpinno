package com.example.goToTeatro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Biglietto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private Spettacolo spettacolo;

    @ManyToOne
    private Posto posto;

    public Biglietto(LocalDateTime timestamp, Utente utente, Spettacolo spettacolo, Posto posto) {
        this.timestamp = timestamp;
        this.utente = utente;
        this.spettacolo = spettacolo;
        this.posto = posto;
    }
}
