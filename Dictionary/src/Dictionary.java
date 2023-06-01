import com.sun.source.tree.Tree;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
public class Dictionary {

    private Map<String, Map<String, Set<String>>> dictionary;

    public Dictionary() {
        dictionary = new TreeMap<>();
        dictionary.put("a", new TreeMap<>());
        dictionary.put("b", new TreeMap<>());
        dictionary.put("c", new TreeMap<>());
        dictionary.put("d", new TreeMap<>());
        dictionary.put("e", new TreeMap<>());
        dictionary.put("f", new TreeMap<>());
        dictionary.put("g", new TreeMap<>());
        dictionary.put("h", new TreeMap<>());
    }

    public void inserisciParola(String parola, Set<String> significato){
        Map<String, Set<String>> parole = dictionary.get(String.valueOf(parola.charAt(0)));
        parole.put(parola, significato);
    }

    public boolean cercaParola(String parola) throws WordNotPresentException{
        Map<String, Set<String>> parole = dictionary.get(String.valueOf(parola.charAt(0)));
        if(parole.get(parola) != null) {
            return true;
        } else {
            throw new WordNotPresentException();
        }
    }

    public void aggiungiSignificato(String parola, String significato) throws MeaningAlreadyExistingException{
        boolean bol = false;
        try {
            bol = cercaParola(parola);
        } catch (WordNotPresentException e) {
            System.out.println(e);
        }
        Map<String, Set<String>> parole = dictionary.get(String.valueOf(parola.charAt(0)));
        Set<String> set = parole.get(parola);
        if (set!=null){
            if(set.contains(significato)){
                throw new MeaningAlreadyExistingException();
            }
        } else {
            set = new TreeSet<>();
        }
        if(bol){
            set.add(significato);
            parole.put(parola, set);
            dictionary.put(String.valueOf(parola.charAt(0)), parole);
        }

    }

    @Override
    public String toString() {
        String res = "";
        for (Map.Entry<String, Map<String, Set<String>>> entry : dictionary.entrySet()){
            res = res + entry.getKey() + ": [";
            for (Map.Entry<String, Set<String>> entry2 : entry.getValue().entrySet()){
                res = res + entry2.getKey() + "(";
                for (String sign : entry2.getValue()){
                    res = res + sign + ";";
                }
                res = res + "),";
            }
            res = res + "]\n";
        }
        return res;
    }
}
