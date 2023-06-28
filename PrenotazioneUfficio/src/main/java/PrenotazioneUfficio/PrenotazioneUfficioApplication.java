package PrenotazioneUfficio;

import PrenotazioneUfficio.model.Città;
import PrenotazioneUfficio.service.CittàService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrenotazioneUfficioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrenotazioneUfficioApplication.class, args);
	}

}
