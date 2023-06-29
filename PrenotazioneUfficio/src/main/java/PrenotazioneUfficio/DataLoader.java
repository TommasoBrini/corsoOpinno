package PrenotazioneUfficio;

import PrenotazioneUfficio.model.Città;
import PrenotazioneUfficio.service.CittàService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    CittàService cittàService;


    @Override
    public void run(String... args) throws Exception {
        //Città c1 = new Città("Milano");
        //cittàService.saveCity(c1);
    }
}
