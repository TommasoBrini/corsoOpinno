import java.time.LocalDate;

public class Prenotazione {

    private int idUnivoco;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private AbitazionePrenotabile abitazione;
    private Utente utente;
    private double prezzo;

    public Prenotazione(int idUnivoco, LocalDate dataInizio, LocalDate dataFine, AbitazionePrenotabile abitazione, Utente utente, double prezzo) {
        this.idUnivoco = idUnivoco;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.abitazione = abitazione;
        this.utente = utente;
        this.prezzo = prezzo;
    }

    public int getIdUnivoco() {
        return idUnivoco;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public AbitazionePrenotabile getAbitazione() {
        return abitazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "idUnivoco=" + idUnivoco +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", utente=" + utente +
                '}';
    }
}
