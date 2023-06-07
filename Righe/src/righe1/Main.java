package righe1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try {
            Path path = Paths.get("src", "righe1", "righe.txt");

            List<String> righe = Files.readAllLines(path);

            Collections.reverse(righe);

            Path res = Paths.get("src", "righe1", "righeInverse.txt");

            Files.write(res, righe);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

