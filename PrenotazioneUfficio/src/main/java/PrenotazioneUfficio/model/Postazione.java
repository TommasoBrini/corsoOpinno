package PrenotazioneUfficio.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Entity
@Data
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String codice;

    private String descrizione;

    private TipoPostazione tipo;

    private int numMaxOccupanti;

    @ManyToOne
    private Edificio edificio;

    public Postazione(String codice, String descrizione, TipoPostazione tipo, int numMaxOccupanti, Edificio edificio) {
        this(null, codice, descrizione, tipo, numMaxOccupanti, edificio);
    }
}
