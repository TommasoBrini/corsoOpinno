import java.util.Random;

public class CasellaPunti extends Casella{

    private int punti;

    public CasellaPunti(int id) {
        super(id);
        this.punti= new Random().nextInt(9) + 1;
    }

    @Override
    public void effettoCasella(Giocatore giocatore) {
        //ASSEGNA PUNTI AL GIOCATORE
        System.out.println("SEI CAPITATO IN UNA CASELLA PUNTI!");
        giocatore.setPunteggio(punti);
        System.out.println("PUNTEGGIO INCREMENTATO DI " + punti + " PUNTI");
    }

    @Override
    public String toString() {
        return "CasellaPunti{" +
                "punti=" + punti +
                '}';
    }
}
