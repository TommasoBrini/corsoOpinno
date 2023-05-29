import java.util.List;
import java.util.Map;

public class Library {

    private Map<Integer, String> archivio;

    public void addLibro(Book libro){
        archivio.put(libro.getCod(),libro.getTitolo()+libro.getAutore());
    }

    public void deleteLibro(Book libro){
        archivio.remove(libro.getCod());
    }

    public void researchLibro(Book libro){
        archivio.get(libro.getCod());
    }


    public StringBuilder stampaLibro(Author autore) {
        return null;
    }

}
