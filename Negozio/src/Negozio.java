import java.util.Arrays;

public class Negozio {
    private Prodotto[] prodotti = {};
    private static final int PROD_MAX = 100;

    public Negozio(){
    }

    public void addProdotto(Prodotto p, int quantità){
        if(Arrays.stream(prodotti).toList().contains(p)){
            int i = Arrays.stream(prodotti).toList().indexOf(p);
            prodotti[i].setQuantity(prodotti[i].getQuantity() + quantità);
            System.out.println("AUMENTATA QUANTITà");
        } else if(prodotti.length < PROD_MAX) {
            Prodotto[] prodottiCopy = new Prodotto[prodotti.length + 1];
            System.arraycopy(prodotti, 0, prodottiCopy, 0, prodotti.length);
            p.setQuantity(p.getQuantity() + quantità);
            prodottiCopy[prodotti.length] = p;
            prodotti = prodottiCopy;
            System.out.println("CREATO NUOVO PRODOTTO");
        } else {
                System.out.println("LIMITE PRODOTTI RAGGIUNTI");
        }
    }

    public double buy(Prodotto p, int quant, Cliente cliente){
        double tot = 0;
        if(Arrays.stream(prodotti).toList().contains(p)){
            int i = Arrays.stream(prodotti).toList().indexOf(p);
            if(prodotti[i].getQuantity() >= quant){
                prodotti[i].setQuantity(prodotti[i].getQuantity()-quant);
                tot = p.getPrice()*quant;
            } else {
                System.out.println("NON ABBIAMO LA QUANTITà SELEZIONATA");
            }
        } else {
            System.out.println("NON ABBIAMO IL PRODOTTO");
        }
        applicaSconto(tot, cliente);
        return tot;
    }

    public String getProductsQuantity(){
        String result = "";
        for (Prodotto prodotto : prodotti) {
            result = result + "\n" + prodotto.getName() + ": " + prodotto.getQuantity();
        }
        return result;
    }

    public void remove(Prodotto p){
        if(Arrays.stream(prodotti).toList().contains(p)) {
            int i = Arrays.stream(prodotti).toList().indexOf(p);
            for (int j = i; j < prodotti.length - 1; j++) {
                prodotti[j] = prodotti[j + 1];
            }
            prodotti = Arrays.copyOf(prodotti, prodotti.length - 1);
            System.out.println("RIMOSSO IL PRODOTTO " + p.getName());
        }
    }

    public double calcolaRata(int mesi, double importo){
        double pagamentoMensile;
        pagamentoMensile= (double)importo/mesi;
        return pagamentoMensile;
    }

    private double applicaSconto(double tot, Cliente cliente){
        double sconto = 0;
        return sconto;
    }



}
