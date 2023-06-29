package com.example.GestionePrenotazioneWebService.repository;

import com.example.GestionePrenotazioneWebService.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
}
