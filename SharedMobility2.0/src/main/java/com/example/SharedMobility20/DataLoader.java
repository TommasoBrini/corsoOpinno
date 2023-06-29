package com.example.SharedMobility20;

import com.example.SharedMobility20.model.*;
import com.example.SharedMobility20.service.PrenotazioneService;
import com.example.SharedMobility20.service.UtenteService;
import com.example.SharedMobility20.service.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UtenteService us;

    @Autowired
    VeicoloService vs;

    @Autowired
    PrenotazioneService ps;

    @Override
    public void run(String... args) throws Exception {

        Utente u1 = new Utente("marco","jaj", LocalDate.now(), "CFFFFFFFF", 1.23);
        Utente u2 = new Utente("luca","jajsadfa", LocalDate.now(), "CFFFasfgdsFFFFF", 11234.23);

        us.saveUtente(u1);
        us.saveUtente(u2);

        Veicolo v1 = new Veicolo(TipoVeicolo.AUTO, "qui", true, 0.64, "TARGAA", TipoPatente.A);
        Veicolo v2 = new Veicolo(TipoVeicolo.MOTO, "qui", true, 0.34, "TARGAb", TipoPatente.B);
        vs.saveVeicolo(v1);
        vs.saveVeicolo(v2);
        vs.saveVeicolo(new Veicolo(TipoVeicolo.BICI, "qui", true, null, null, null));
        vs.saveVeicolo(new Veicolo(TipoVeicolo.MONOPATTINO, "qui", false, 0.70, null, null));
        vs.saveVeicolo(new Veicolo(TipoVeicolo.FURGONCINO, "qui", true, 0.94, "TARGACCC", TipoPatente.C));

        Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant);
        ps.savePrenotazione(new Prenotazione(timestamp, u1, v1));
        ps.savePrenotazione(new Prenotazione(timestamp, u2, v2));

    }
}
