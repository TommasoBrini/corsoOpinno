import java.util.ArrayList;
import java.util.List;

public class Author {

    private int codice;
    private String nome;
    private String cognome;
    private List<Book> libri;

    public Author(int codice, String nome, String cognome) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        libri = new ArrayList<>();
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public List<Book> getLibri() {
        return libri;
    }

    public void addBook(Book libro){
        libri.add(libro);
    }

    public void removeBook(Book book){
        libri.remove(book);
    }
}
