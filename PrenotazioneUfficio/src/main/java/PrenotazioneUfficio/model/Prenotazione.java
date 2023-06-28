package PrenotazioneUfficio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Entity
@Data
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Postazione postazione;

    @ManyToOne
    private Utente utente;

    private LocalDate dataPrenotazione;
    private LocalDate dataPrenotata;

    public Prenotazione(Postazione postazione, Utente utente, LocalDate dataPrenotazione, LocalDate dataPrenotata) {
        this(null, postazione, utente,dataPrenotazione,dataPrenotata);
    }
}
