public class Host extends Utente{
    private int codHost;
    private int numPrenotazioni;

    public Host(int codHost, Utente utente) {
        super(utente.getNome(), utente.getCognome(), utente.getEmail(), utente.getIndirizzo());
        this.codHost = codHost;
        this.numPrenotazioni = 0;
    }

    public int getCodHost() {
        return codHost;
    }

    public int getNumPrenotazioni() {
        return numPrenotazioni;
    }
}
