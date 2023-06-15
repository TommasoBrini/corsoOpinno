import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        MultimappaGenerica<String, String> multiMap = new MultimappaGenerica<>();
        multiMap.put("CHIAVE", "VALORE0S");
        multiMap.put("CHIAVE", "VALORE1");
        multiMap.put("CHIAVE", "VALORE2");

        MultimappaGenerica<String, String> multiMap2 = new MultimappaGenerica<>();
        multiMap2.put("CHIAVE2", "VALORE1");
        multiMap2.put("CHIAVE2", "valore2");
        multiMap2.put("CHIAVE2", "valore3");

        System.out.println("*** AGGIUNGO MULTIMAP2 ***");
        multiMap.putAll(multiMap2);
        System.out.println(multiMap);

        System.out.println("*** RIMUOVO MULTIMAP2 ***");
        multiMap.removeAll(multiMap2);
        System.out.println(multiMap);

        System.out.println("*** VALORI CON CHIAVE 1 ***");
        System.out.println(multiMap.get("CHIAVE"));

        System.out.println("*** VALORI CON CHIAVE 1 CHE CONTENGONO S ***");
        System.out.println(multiMap.get("CHIAVE", str -> str.contains("S")));

        multiMap.putAll(multiMap2);

        System.out.println("*** VALORI CON DUPLICATI CONTENUTI NELLA MULTIMAPPA ***");
        System.out.println(multiMap.values());

        System.out.println("*** VALORI NON DUPLICATI CONTENUTI NELLA MULTIMAPPA ***");
        System.out.println(multiMap.valueSet());

        System.out.println("*** TRASFORMO I VALORI IN INTERI ***");
        System.out.println(multiMap.tranformToMultiMappa((key,value) -> value.length()));

        System.out.println("*** AGGIUNGO ciao A OGNI VALORE ***");
        multiMap.mapEach((key,value)-> value + "ciao");
        System.out.println(multiMap);

        System.out.println("*** Iterating through the map: ***");
        for (MultimappaGenerica.Elemento<String, String> element : multiMap) {
            System.out.println("Key: " + element.getKey() + ", Value: " + element.getValue());
        }

    }
}
