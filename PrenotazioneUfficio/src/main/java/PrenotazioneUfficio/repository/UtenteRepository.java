package PrenotazioneUfficio.repository;

import PrenotazioneUfficio.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
}
