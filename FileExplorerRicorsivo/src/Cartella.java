import java.io.File;
import java.nio.file.Path;

public class Cartella {
    Path path;

    public Cartella(Path percorso) {
        path = percorso;
    }

    public void stampa(){
        System.out.println("" + path);
    }

    public String cercaFile(String nomeFile){
        StringBuilder sb = new StringBuilder();
        cercaFile(new File(path.toString()), nomeFile, sb);
        return sb.toString();
    }

    private void cercaFile(File cartella, String nomeFile, StringBuilder sb) {
        File[] files = cartella.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    cercaFile(file, nomeFile, sb);
                } else if (file.getName().equals(nomeFile)) {
                    sb.append(file.getAbsolutePath()).append("\n");
                }
            }
        }
    }

}

