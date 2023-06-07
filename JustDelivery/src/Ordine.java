import java.util.ArrayList;
import java.util.List;

public class Ordine {
    private Ristorante ristorante;
    private ArrayList<Prodotto> prodotti;
    private double prezzoTot = 0;

    public Ordine(ArrayList<Prodotto> prodotti ,Ristorante ristorante ) {
        this.prodotti = prodotti;
        this.ristorante = ristorante;
        calcolaPrezzo();
    }

    public void calcolaPrezzo(){
        double sum=0;
        for(Prodotto p : prodotti){
            sum+=p.getPrezzo();
        }
//        double sommaPrezzi = 0.0;
//        prodotti.stream().mapToDouble(Prodotto::getPrezzo).forEach(p -> sommaPrezzi += p);
        this.prezzoTot=sum + getRistorante().getSpesaSpedizione();

    }
    public void aggiungiProdotti(List<Prodotto> prodotti) {
        this.prodotti.addAll(prodotti);
        calcolaPrezzo();
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
        calcolaPrezzo();
    }

    public ArrayList<Prodotto> getProdotti(){
        return prodotti;
    }
    public Ristorante getRistorante(){
        return ristorante;
    }
    public double getPrezzoTot() {
        return prezzoTot;
    }

    @Override
    public String toString() {
        return " Prodotti=" + prodotti.toString() + ", prezzoTot=" + prezzoTot + ",  di cui le spese di spedizione sono= " + getRistorante().getSpesaSpedizione();
    }
}