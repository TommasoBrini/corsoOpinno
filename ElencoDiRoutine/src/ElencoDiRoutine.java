import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ElencoDiRoutine {

    List<Function<String, Integer>> functions = new ArrayList<>();

    public void esegui(String stringa){
        // Eseguire ogni funzione all'interno di functions e stampare il risultato finale
        for (Function<String, Integer> function : functions) {
            int res;
            try{
                res = function.apply(stringa);
            } catch (Exception e){
                res = 0;
            }

            System.out.println(stringa + " : " + res);
        }
    }

    public void addFunction(Function<String, Integer> f){
        functions.add(f);
    }
}

