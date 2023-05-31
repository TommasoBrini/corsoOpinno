public class Feedback {
    private int id;
    private String titolo;
    private String testo;
    private int punteggio;
    private Host proprietario;
    private Utente utente;

    public Feedback(int id, String titolo, String testo, int punteggio, Host host, Utente utente) {
        this.id = id;
        this.titolo = titolo;
        this.testo = testo;
        this.punteggio = punteggio;
        this.proprietario = host;
        this.utente = utente;
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getTesto() {
        return testo;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public Host getProprietario() {
        return proprietario;
    }

    public Utente getUtente() {
        return utente;
    }
}
