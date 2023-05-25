import java.util.Random;

public class CasellaSpostaGiocatore extends Casella{

    private int pos;

    public CasellaSpostaGiocatore(int id) {
        super(id);
        pos = new Random().nextInt(11) - 5;

    }

    @Override
    public void effettoCasella(Giocatore giocatore) {
        //SPOSTA IL GIOCATORE
        System.out.println("SEI CAPITATO IN UNA CASELLA SPOSTAMENTO!");
        giocatore.setPosizioneAttuale(pos);
        System.out.println("POSIZIONE INCREMENTATO DI " + pos + " PUNTI");
    }

    @Override
    public String toString() {
        return "CasellaSpostaGiocatore{" +
                "pos=" + pos +
                '}';
    }
}
