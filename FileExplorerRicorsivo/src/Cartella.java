import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Cartella {
    Path path;

    public Cartella(Path percorso) {
        path = percorso;
    }

    public void stampa(){
        System.out.println(path.toString());
        File file = new File(path.toString());
        System.out.println(file.listFiles());
    }

    public Path getPath() {
        return path;
    }


    /**
     * Cerca file all'interno di una cartella
     * @param directory cartella madre dove cercare il file
     * @param nomeFile nome del file da cercare
     * @return strina del percorso del file trovato
     */
    public String cercaFile(File directory, String nomeFile) {
        // creare un array con tutti i file/cartelle nella cartella directory
        File[] files = directory.listFiles();

        // cicla per ogni file/cartella che trova in files
        for(File file : files){
            if(file.isDirectory()){
                //se file è una cartella, chiamata ricorsiva passando questa cartella (file) e il nome del file da cercare
                String res = cercaFile(file, nomeFile);
                if(res != null){
                    // se trova il file, restituire res
                    return res;
                }
            } else {
                if(file.getName().equals(nomeFile)){
                    //Se il nome del file da trovare è uguale al nome di file, ritornare il percorso come stringa
                    return "Path File: " + file.getPath();
                }
            }
        }
        return null;
    }

    /**
     * Cercare ricorsivamente un file all'interno di una sottocartella
     * @param sottocartella sottocartella in cui cercare
     * @param nomeFile nome del file da cercare
     * @return la stringa del percorso del file trovato
     */
    public String cercaFileInSottoCartella(String sottocartella, String nomeFile){
        //creo la cartella a partite dalla stringa sottocartella, contenente il nome
        File subDirectory = new File(path.toString(), sottocartella);
        //chiamo cercaFile passandogli come cartella principale la sottocartella selezionata
        return cercaFile(subDirectory, nomeFile);
    }

    /**
     * Cerca all'interno della cartella tutti i file con l'estensione specificata
     * @param directory cartella madre in cui cercare
     * @param estensione estensione specificata
     * @return lista dei nomi dei file con estensione specificata trovati
     */
    public List<String> cercaFileByEstensione(File directory, String estensione){
        //Creo uno nuovo array che conterrà i risultati finali
        List<String> res = new ArrayList<>();
        //Cerco tutti i file/cartelle all'interno della cartella directory
        File[] files = directory.listFiles();
        for (File f : files){
            if(f.isDirectory()){
                //Se f è una cartella, richiamo ricorsivamente passando f come nuova cartella madre
                //assegno in una lista di appoggio i risultati trovati nella ricorsione
                List<String> resRicorsivi = cercaFileByEstensione(f, estensione);
                //aggiungo alla lista dei risultati tutti i risultati trovati nella ricorsione, salvati in resRicorsivi
                res.addAll(resRicorsivi);
            } else{
                if(f.getName().endsWith(estensione)){
                    //se f è un file con estensione specificata lo aggiungo a res
                    res.add(f.getPath().toString());
                }
            }
        }
        return res;
    }

}

