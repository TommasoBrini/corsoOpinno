package righe2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader;

        Map<String, List<String>> mappa = new HashMap<>();

        {
            try {
                Path path = Paths.get("src", "righe2", "righe2.txt");

                reader = Files.newBufferedReader(path);

                String riga;
                while ((riga = reader.readLine()) != null) {
                    String[] array1 = riga.split(":");
                    String chiave = array1[0];
                    List<String> values = new ArrayList<>();
                    for (int i = 1; i < array1.length; i++) {
                        String[] array2 = array1[i].split(",");
                        for (String s : array2) {
                            values.add(s);
                        }
                    }
                    mappa.put(chiave, values);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(mappa);
    }


}
