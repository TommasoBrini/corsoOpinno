import java.util.ArrayList;

public class Ordine {
    private Ristorante ristorante;
    private ArrayList<Prodotto> prodotti;
    private double prezzoTot;

    public Ordine(ArrayList<Prodotto> prodotti ,Ristorante ristorante ) {
        this.prodotti = prodotti;
        this.ristorante = ristorante;
    }

    public void calcolaPrezzo(){
        double sum=0;
        for(Prodotto p : prodotti){
            sum+=p.getPrezzo();
        }
//        double sommaPrezzi = 0.0;
//        prodotti.stream().mapToDouble(Prodotto::getPrezzo).forEach(p -> sommaPrezzi += p);
        this.prezzoTot=sum;

    }
    public void aggiungiProdotti(ArrayList<Prodotto> prodotti) {
        this.prodotti.addAll(prodotti);
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

}
