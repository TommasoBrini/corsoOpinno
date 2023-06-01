import java.util.Set;
import java.util.TreeSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws MeaningAlreadyExistingException {
        Dictionary dictionary = new Dictionary();
        System.out.println(dictionary);

        Set<String> significato1 = new TreeSet<>();
        significato1.add("alta temperatura");
        significato1.add("pieno di passione");

        Set<String> significato2 = new TreeSet<>();
        significato2.add("impugnatura della pistola");
        significato2.add("sport");
        significato2.add("elemento chimico");

        dictionary.inserisciParola("caldo", significato1);
        dictionary.inserisciParola("calcio", significato2);

        System.out.println("*** AGGIUNTA PAROLE ***");
        System.out.println(dictionary);

        try {
            dictionary.aggiungiSignificato("ciao", "saluto");
            dictionary.aggiungiSignificato("calcio", "elemento chimico");
        } catch (MeaningAlreadyExistingException e) {
            //throw new RuntimeException(e);
            System.out.println(e);
            System.out.println();
        }

        dictionary.aggiungiSignificato("calcio", "colpo nelle palle");


        System.out.println(dictionary);
    }
}