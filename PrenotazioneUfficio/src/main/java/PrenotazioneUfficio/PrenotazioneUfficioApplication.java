package PrenotazioneUfficio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrenotazioneUfficioApplication {

	public static void main(String[] args) {

		//Postazione p = new Postazione("ciao", "Desc", TipoPrenotazione.OPENSPACE, 23, new Edificio("chs", "ind"));

		SpringApplication.run(PrenotazioneUfficioApplication.class, args);
	}

}
