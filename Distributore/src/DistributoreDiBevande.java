public class DistributoreDiBevande {
    private Prodotto[] prodottoList;
    private double saldo;

    private int n;

    public DistributoreDiBevande(int l){
        prodottoList = new Prodotto[l];
        n = 0;
    }

    public void caricaProdotto(Prodotto prodotto){
        if(n<prodottoList.length){
            prodottoList[n] = prodotto;
            n++;
        } else {
            System.out.println("NON PUOI AGGIUNGERE");
        }
    }

    public void inserisciImporto(double importo){
        saldo += importo;
    }

    public Prodotto scegliProdotto(String codProd){
        for (Prodotto prodotto : prodottoList) {
            if(prodotto != null && prodotto.getCod().equals(codProd) && prodotto.getPrezzo() <= saldo){
                saldo -= prodotto.getPrezzo();
                return prodotto;
            }
        }
        return null;
    }

    public double saldoAttuale() {
        return saldo;
    }

    public double getResto(){
        double resto = saldo;
        saldo = 0;
        return resto;
    }
}
