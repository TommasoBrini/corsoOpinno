package PrenotazioneUfficio;

import PrenotazioneUfficio.model.*;
import PrenotazioneUfficio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    CittàService cittàService;

    @Autowired
    EdificioService edificioService;

    @Autowired
    PostazioneService postazioneService;

    @Autowired
    PrenotazioneService prenotazioneService;

    @Autowired
    UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {

        Città c1 = new Città("Milano");
        cittàService.saveCity(c1);

        Edificio e1 = new Edificio("Museo", "Via Giovanni da Procida", c1);
        Edificio e2 = new Edificio("Casa", "Via Brambilla Fumagalli", c1);
        edificioService.saveEdificio(e1);
        edificioService.saveEdificio(e2);
        System.out.println(edificioService.getAllEdificio());
        edificioService.deleteEdificio(e1);
        System.out.println(edificioService.getAllEdificio());

        Postazione po1 = new Postazione("uno", "bello", TipoPostazione.OPENSPACE, 12, e2);
        postazioneService.savePostazione(po1);

        Utente u1 = new Utente("Mariotto","Mario", "mario@", "MaRiO");
        utenteService.saveUser(u1);

        Prenotazione pr1 = new Prenotazione(po1, u1, LocalDate.now(), LocalDate.now());
        prenotazioneService.savePrenotazione(pr1);


    }
}
