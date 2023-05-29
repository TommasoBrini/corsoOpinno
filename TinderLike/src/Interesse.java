public class Interesse {
    private int codice;
    private String testo;

    public Interesse(int codice, String testo) {
        this.codice = codice;
        this.testo = testo;
    }

    public int getCodice() {
        return codice;
    }

    public String getTesto() {
        return testo;
    }

    @Override
    public String toString() {
        return testo;
    }
}
