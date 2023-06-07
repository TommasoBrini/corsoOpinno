import java.nio.file.Paths;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cartella cartella = new Cartella(Paths.get("FileExplorerRicorsivo", "test_folder"));

        System.out.println(cartella.cercaFile("file1.txt"));
    }
}