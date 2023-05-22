
import java.util.Arrays;

public class Negozio {

    private static final int MAX_QUANTITY = 100;
    private static final int SCONTO_PERCENT = 20;
    private static final int AGE_SCONTO = 60;
    private Prodotto[] prodotti = {};

    public Negozio() {
    }

    public Negozio(Prodotto[] prodotti) {
        this.prodotti = prodotti;
    }

    public void addProdotto(Prodotto p, int quant) {            //AGGIUNGIAMO PRODOTTO + LA QUANTITA' DA AGGIUNGERE
        if (Arrays.stream(prodotti).toList().contains(p)) {     //IN PRODOTTI è PRESENTE IL PRODOTTO P
            int i = Arrays.stream(prodotti).toList().indexOf(p);    //MEMORIZZZIAMO NELL'INDICE "i"  LA POSIZIONE DEL PRODOTTO "P" IN PRODOTTI
            prodotti[i].setQuantity(prodotti[i].getQuantity() + quant);     //SETTIAMO LA NUOVA QUANTITA' DI PRODOTTO
        } else if (prodotti.length < MAX_QUANTITY) {            //IN PRODOTTI NON E' PRESENTE "p" E LA LUNGHEZZA DELL'ARRAY è MINORE DI 100
            Prodotto[] prodottiCopy = new Prodotto[prodotti.length + 1];
            System.arraycopy(prodotti, 0, prodottiCopy, 0, prodotti.length);
            p.setQuantity(p.getQuantity() + quant);
            prodottiCopy[prodotti.length] = p;
            prodotti = prodottiCopy;        //MEMORIZZIAMO IL NUOVO PRODOTTO CON LA RISPETTIVA QUANTITA' IN UN NUOVO ARRAY PIU GRANDE

        } else {//IN PRODOTTI  NON è PRESENTE IL PRODOTTO P     E       I PRODOTTI SONO PIU' DI 100
            System.out.println("Inserendo " + quant + "prodotti supererai la  quantità massima (100)");
        }

    }

    public void remProdotto(Prodotto p) {                //RIMUOVIAMO PRODOTTO
        if (Arrays.stream(prodotti).toList().contains(p)) {
            int i = Arrays.stream(prodotti).toList().indexOf(p);
            for (int j = i; j < prodotti.length - 1; j++) {
                prodotti[j] = prodotti[j + 1];
            }
            prodotti = Arrays.copyOf(prodotti, prodotti.length - 1);
            System.out.println("RIMOSSO IL PRODOTTO " + p.getName());
        }

    }


    public StringBuilder getProdotto() {
        StringBuilder nomeQuant = new StringBuilder("");
        for (int j = 0; j < prodotti.length; j++) {
            nomeQuant.append("[nome: " + prodotti[j].getName() + ", quantità: " + prodotti[j].getQuantity() + "]");
        }
        return nomeQuant;
    }


    public double buy(Prodotto p, int quant, Cliente cliente, Settimana giorno) {
        return buy(new Prodotto[]{p}, new int[]{quant}, cliente, giorno);
    }

    private double calcoloBuy(Prodotto p, int quant, Cliente cliente, Settimana giorno) {
        double tot = 0;
        if (Arrays.stream(prodotti).toList().contains(p)) {         //IN PRODOTTI è PRESENTE IL PRODOTTO P
            int i = Arrays.stream(prodotti).toList().indexOf(p);    //MEMORIZZZIAMO NELL'INDICE "i"  LA POSIZIONE DEL PRODOTTO "P" IN PRODOTTI
            if (prodotti[i].getQuantity() < quant) {                    //SE LA QUANTITA'  E' MINORE DI QUELLA RICHIESTA
                System.out.println("QUANTIA' NON DISPONIBILE" + " TU CHIEDI " + quant + " MA CE NE SONO " + p.getQuantity());
            } else {                                                            //SE LA QUANTITA'  E' SUFFICIENTE PER QUELLA RICHIESTA
                prodotti[i].setQuantity(prodotti[i].getQuantity() - quant);     //SETTIAMO LA NUOVA QUANTITA' DI PRODOTTO
                tot = (p.getPrice() - applicaSconto(p, cliente, giorno)) * quant;
            }

        } else {
            System.out.println("PRODOTTO NON PRESENTE");
        }

        return tot;

    }

    public double buy(Prodotto[] p, int[] quantity, Cliente cliente, Settimana giorno) {
        double tot = 0;
        for (int i = 0; i < p.length; i++) {
            tot += calcoloBuy(p[i], quantity[i], cliente, giorno);
        }
        int puntiCoupon = (int) tot / 10;
        cliente.setPointsCoupon(cliente.getPointsCoupon() + puntiCoupon);
        tot -= applicaCoupon(cliente);
        return tot;

    }

    private int applicaCoupon(Cliente cliente) {
        int scontoCoupon;
        scontoCoupon = (int) cliente.getPointsCoupon() / 10;
        cliente.setPointsCoupon(cliente.getPointsCoupon() - scontoCoupon * 10);
        return scontoCoupon;
    }

    private double applicaSconto(Prodotto prodotto, Cliente cliente, Settimana giorno) {
        double sconto = 0;
        if (cliente.getAge() >= Negozio.AGE_SCONTO && (giorno == Settimana.LUNEDI || giorno == Settimana.MERCOLEDI) && prodotto instanceof Alimentare) {
            sconto = prodotto.getPrice() * SCONTO_PERCENT / 100;
            System.out.println("lo sconto è : " + sconto);
        }
        return sconto;
    }

    public double calcolaRata(double importo) {
        return calcolaRata(12, importo);
    }

    public double calcolaRata(int mesi, double importo) {
        double pagamentoMensile;
        pagamentoMensile = (double) importo / mesi;
        return Math.round(pagamentoMensile * 100.0) / 100.0;
    }


}
