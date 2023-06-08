import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cartella cartella = new Cartella(Paths.get("test_folder"));

        System.out.println(cartella.cercaFile("file3.csv"));

        System.out.println(cartella.cercaFileInSottoCartella("folder2", "file2.txt"));

        System.out.println(cartella.cercaFileByEstensione(new File(cartella.getPath().toString()), ".txt"));

        System.out.println(cartella.cercaFileByEstensione(new File(cartella.getPath().toString()), Arrays.asList(".csv", ".md")));

        System.out.println();

        System.out.println(cartella);
    }
}