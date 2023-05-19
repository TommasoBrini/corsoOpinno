public class TestNegozio {
    public static void main(String[] args) {
        Alimentare banane = new Alimentare("banane", 123);
        Alimentare mela = new Alimentare("mela", 123, 45);
        Negozio negozio = new Negozio();
        Cliente tom = new Cliente("Tommi", 45);
        //CREO UN PRODOTTO
        negozio.addProdotto(banane, 2);
        negozio.addProdotto(mela, 5);

        System.out.println(negozio.getProductsQuantity());

        negozio.addProdotto(banane, 1);
        System.out.println(negozio.getProductsQuantity());

        negozio.remove(mela);
        System.out.println(negozio.getProductsQuantity());

        //double spesa1 =negozio.buy(banane, 100);
        //System.out.println("Hai speso " + spesa1);
        System.out.println(negozio.getProductsQuantity());

        //double spesa2 = negozio.buy(banane, 2);
        //System.out.println("Hai speso " + spesa2);
        System.out.println(negozio.getProductsQuantity());

        //negozio.buy(banane, 1);
        System.out.println(negozio.getProductsQuantity());

        //negozio.buy(banane, 1);
        System.out.println(negozio.getProductsQuantity());

    }
}
