import lombok.AllArgsConstructor;
import lombok.Getter;

public class Persona {

    private String nome;
    private String cognome;
    private int eta;
    private String CF;
    private String indirizzo;

    public Persona(String nome, String cognome, int eta, String CF, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.CF = CF;
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public String getCF() {
        return CF;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
}
