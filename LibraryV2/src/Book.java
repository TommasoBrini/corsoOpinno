public class Book {

    private int cod;
    private String titolo;
    private String sinossi;
    private Author autore;

    public Book(int cod, String titolo, String sinossi, Author autore) {
        this.cod = cod;
        this.titolo = titolo;
        this.sinossi = sinossi;
        this.autore = autore;
        this.autore.addBook(this);
    }

    public int getCod() {
        return cod;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getSinossi() {
        return sinossi;
    }

    public Author getAutore() {
        return autore;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj || obj == null || getClass() != obj.getClass()){
            return false;
        }
        Book book = (Book) obj;
        return this.getCod() == book.getCod();
    }

    @Override
    public String toString() {
        return titolo + ": " + sinossi;
    }
}
