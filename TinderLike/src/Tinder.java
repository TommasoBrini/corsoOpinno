import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tinder {
    Set<Utente> utenti = new HashSet<>();

    public void addUtente(Utente utente){
        utenti.add(utente);
    }

    public void remove(Utente utente){
        utenti.remove(utente);
    }

    public Utente cercaAmico(Utente utente){
        int maxCount = 0;
        Utente res = null;
        for(Utente ut : utenti){
            int count = 0;
            for (Interesse inter : utente.getInteressi()){
                if(utente.getInteressi().contains(inter)){
                    count++;
                }
            }
            if(count > maxCount){
                res = ut;
            }
        }
        return res;
    }
}
