public class Book {

    private int indice;
    private String name;
    private String author;

    public Book(int indice, String name, String author){
        this.indice = indice;
        this.name = name;
        this.author = author;
    }

    public int getIndice() {
        return indice;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
