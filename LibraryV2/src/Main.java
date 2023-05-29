// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        Author author1 = new Author(1, "Stephen", "King");
        Author author2 = new Author(2, "Dante", "Alighieri");

        Book book = new Book(1, "Shining", "Fa cagare sotto", author1);
        Book book2 = new Book(2, "It", "Fa ancora più scagazzare", author1);
        Book book3 = new Book(3, "Divina Commedia", "Che palle", author2);

        myLibrary.addLibro(book);
        myLibrary.addLibro(book2);
        myLibrary.addLibro(book3);

        System.out.println(myLibrary.research(2));
        System.out.println(myLibrary.research("It"));
        System.out.println(myLibrary.research(author1));

        System.out.println(myLibrary.stampaLibro(author1));

        myLibrary.deleteLibro(book);

        System.out.println(myLibrary.stampaLibro(author1));

    }
}