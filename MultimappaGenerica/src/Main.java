import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        MultimappaGenerica<String, String> multiMap = new MultimappaGenerica<>();
        multiMap.put("CHIAVE", "VALORE");
        multiMap.put("CHIAVE", "VALORE1");
        multiMap.put("CHIAVE", "VALORE2");

        MultimappaGenerica<String, String> multiMap2 = new MultimappaGenerica<>();
        multiMap2.put("CHIAVE2", "valore");
        multiMap2.put("CHIAVE2", "valore");
        multiMap2.put("CHIAVE2", "valore");

        multiMap.putAll(multiMap2);


        System.out.println(multiMap.get("CHIAVE2"));
    }
}
