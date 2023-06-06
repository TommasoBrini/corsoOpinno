import java.util.ArrayList;
import java.util.UUID;

public class Utente {
    String nome;
    UUID id;
    ArrayList<Ordine> ordini;
    Ordine ordineCorrente;

    public Utente(String nome, UUID id) {
        this.nome = nome;
        this.id = id;
        ordini = new ArrayList<>();
    }


    public void aggiungiOrdine(ArrayList<Prodotto> prodotti, Ristorante ristorante) {
        if (ordineCorrente == null) {
            ordineCorrente = new Ordine(prodotti, ristorante);
        } else {
            ordineCorrente.aggiungiProdotti(prodotti);
        }
    }

    public Ordine chiudiOrdine() {
        Ordine ordineConcluso = new Ordine(ordineCorrente.getProdotti(), ordineCorrente.getRistorante());
        ordineCorrente = null;
        ordini.add(ordineConcluso);
        return ordineConcluso;
    }


    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }

    public Ordine getOrdineCorrente() {
        return ordineCorrente;
    }
}
