package lampadina;

public class Impianto {
    private boolean stato;

    public Impianto(boolean statoCorrente){
        stato = statoCorrente;
    }

    public void generatore(){
        stato = !stato;
    }

    public boolean isStato() {
        return stato;
    }
}
