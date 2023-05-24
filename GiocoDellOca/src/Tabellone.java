import java.util.Arrays;
import java.util.Random;

public class Tabellone {
    private Casella[] caselle;
    private int lunghezza;

    public Tabellone(int n){
        //CREO IL TABELLONE DI LUNGHEZZA n
        this.lunghezza = n;
        caselle = new Casella[lunghezza];
        generaTabellone();
        System.out.println(Arrays.toString(caselle));
    }

    private void generaTabellone(){
        for (int i = 0; i < 5; i++){
            caselle[i] = new CasellaVuota(i);
        }
        for (int i = 5; i < lunghezza - 5; i++){
            int cas = new Random().nextInt(3);
            switch (cas){
                case 0:
                    caselle[i] = new CasellaPunti(i);
                    break;
                case 1:
                    caselle[i] = new CasellaVuota(i);
                    break;
                case 2:
                    caselle[i] = new CasellaSpostaGiocatore(i);
                    break;
            }
        }
        for (int i = lunghezza-5; i < lunghezza; i++){
            caselle[i] = new CasellaVuota(i);
        }
    }

    public void spostaGiocatore(Giocatore giocatore){
        int num = giocatore.lanciaDadi();
        giocatore.setPosizioneAttuale(num);
        caselle[giocatore.getPosizioneAttuale()].effettoCasella(giocatore);
    }
}
