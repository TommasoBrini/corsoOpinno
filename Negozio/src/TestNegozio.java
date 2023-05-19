package Negozio;

public class TestNegozio {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Massimo",61);
        Cliente cliente2 = new Cliente("giovane",59);

        Prodotto p1 = new Alimentare("mela",10,100);
        Prodotto p2 = new Alimentare("pera",20,100);
        Prodotto p3 = new Alimentare("melaViola",30,100);
        Prodotto p4 = new Prodotto("ruota",40,1);

        Prodotto[] prodotti = new Prodotto[] {p1, p2, p3};
        int[] quantity = {6, 4, 8};     //mela 0 + 20*4 + 30*8= 320
        Negozio negozio = new Negozio();

        negozio.addProdotto(p1,0);
        negozio.addProdotto(p2,0);
        negozio.addProdotto(p3,0);
        negozio.addProdotto(p4,0);
        System.out.println(negozio.getProdotto());
        double res1=negozio.buy(prodotti,quantity,cliente,Settimana.MERCOLEDI);
        System.out.println(res1);

        System.out.println(negozio.getProdotto());

        double res2=negozio.buy(prodotti,quantity,cliente2,Settimana.MERCOLEDI);

        System.out.println(res2);


        System.out.println(negozio.getProdotto());

        System.out.println(negozio.calcolaRata(2,res1));
        System.out.println(negozio.calcolaRata(2,res2));
        System.out.println(cliente2.getPointsCoupon());

       // System.out.println(negozio.getProdotto());
    }
}
