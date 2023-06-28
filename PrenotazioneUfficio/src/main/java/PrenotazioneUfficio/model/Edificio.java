package PrenotazioneUfficio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String indirizzo;

    @ManyToOne
    private Città città;

    public Edificio(String nome, String indirizzo, Città città) {
        this(null, nome, indirizzo, città);
    }
}
