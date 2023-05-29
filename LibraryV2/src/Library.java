import java.util.*;

public class Library {

    private Map<Integer, Book> archivio;

    public Library() {
        this.archivio = new HashMap<>();
    }

    public void addLibro(Book libro){
        archivio.put(libro.getCod(),libro);
    }

    public void deleteLibro(Book libro){
        libro.getAutore().removeBook(libro);
        archivio.remove(libro.getCod());
    }

    public Book research(int codice){
        return archivio.get(codice);
    }

    public List<Book> research(String titolo){
        List<Book> res = new ArrayList<>();
        for(Book book : archivio.values()){
            if(book.getTitolo().equals(titolo)){
                res.add(book);
            }
        }
        return res;
    }

    public List<Book> research(Author author){
        List<Book> res = new ArrayList<>();
        for(Book book : archivio.values()){
            if(book.getAutore().equals(author)){
                res.add(book);
            }
        }
        return res;
    }

    public StringBuilder stampaLibro(Author autore) {
        StringBuilder res = new StringBuilder();
        List<Book> list  = autore.getLibri();
        list.sort(Comparator.comparing(Book::getTitolo));
        for (Book book : list) {
            res.append(book.toString()).append("\n");
        }
        return res;
    }

    public Collection<Book> getArchivio() {
        return archivio.values();
    }
}
