public class Riparazione {
    private String indirizzo;
    private int priorità;

    private String conclusa = "";

    public Riparazione(String indirizzo, int priorità) {
        this.indirizzo = indirizzo;
        this.priorità = priorità;
    }

    public void setConclusa(String nome) {
        this.conclusa = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getConclusa() {
        return conclusa;
    }

    public int getPriorità() {
        return priorità;
    }
}
