import java.time.LocalDate;

public class AbitazionePrenotabile extends Abitazione{
    private double prezzo;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    public AbitazionePrenotabile(Abitazione abitazione, double prezzo, LocalDate dataInizio, LocalDate dataFine) {
        super(abitazione.getIdUnivoco(), abitazione.getNome(), abitazione.getIndirizzo(), abitazione.getNumLocali(), abitazione.getNumPosti(), abitazione.getPiano(), abitazione.getHost());
        this.prezzo = prezzo;
        this.dataFine = dataFine;
        this.dataInizio = dataInizio;
    }


}
