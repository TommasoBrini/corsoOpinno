import java.util.Arrays;
import java.util.Comparator;

public class Classifica {

    private Squadra[] classifica;

    public Classifica(Squadra[] classifica) {
        this.classifica = classifica;
    }

    public void esitoPartita(Squadra casa, int golCasa, Squadra ospite, int golOspite){
        if (golCasa > golOspite){
            casa.setPunteggio(casa.getPunteggio() + 3);
        } else if (golCasa == golOspite){
            casa.setPunteggio(casa.getPunteggio() + 1);
            ospite.setPunteggio(ospite.getPunteggio() + 1);
        } else {
            ospite.setPunteggio(ospite.getPunteggio() + 3);
        }

        casa.setGolFatti(casa.getGolFatti() + golCasa);
        casa.setGolSubiti(casa.getGolSubiti() + golOspite);
        ospite.setGolFatti(ospite.getGolFatti() + golOspite);
        ospite.setGolSubiti(ospite.getGolSubiti() + golCasa);

    }

    public Squadra[] getClassifica(){
        Arrays.sort(classifica, Comparator.comparingInt(Squadra::getPunteggio).reversed());
        return classifica;
    }

    public Squadra getMigliorAttacco(){
        Squadra migliorAttacco = classifica[0];
        for (Squadra squadra : classifica) {
            if(squadra.getGolFatti() > migliorAttacco.getGolFatti()){
                migliorAttacco = squadra;
            }
        }
        return migliorAttacco;
    }

    public Squadra getPeggiorDifesa(){
        Squadra peggiorDifesa = classifica[0];
        for (Squadra squadra : classifica) {
            if(squadra.getGolSubiti() > peggiorDifesa.getGolSubiti()){
                peggiorDifesa = squadra;
            }
        }
        return peggiorDifesa;
    }

}
