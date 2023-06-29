package com.example.GestionePrenotazioneWebService.repository;

import com.example.GestionePrenotazioneWebService.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
}
