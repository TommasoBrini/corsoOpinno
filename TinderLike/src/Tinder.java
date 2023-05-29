import java.util.*;

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

    public Set<Utente> utentiPiuSimili(){
        Map<Set<Utente>, Integer> map = new HashMap<>();
        for(Utente ut : utenti){
            for (Utente ut2 : utenti){
                int count = 0;
                if(!ut.equals(ut2)){
                    Set<Utente> list = new HashSet<>();
                    list.add(ut);
                    list.add(ut2);
                    for(Interesse inter : ut.getInteressi()){
                        if(ut2.getInteressi().contains(inter)){
                            count++;
                        }
                    }
                    map.put(list, count);
                }
            }
        }
        Set<Utente> chiaveMax = null;
        int valoreMax = Integer.MIN_VALUE;

        for (Map.Entry<Set<Utente>, Integer> entry : map.entrySet()) {
            if (entry.getValue() > valoreMax) {
                valoreMax = entry.getValue();
                chiaveMax = entry.getKey();
            }
        }
        return chiaveMax;
    }
}
