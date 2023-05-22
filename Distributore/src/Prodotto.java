public class Prodotto {
    private String bevande;
    private double prezzo;

    public Prodotto(String bevande, double prezzo) {
        this.bevande = bevande;
        this.prezzo = prezzo;
    }

    public String getCod() {
        return bevande;
    }

    public double getPrezzo() {
        return prezzo;
    }
}
