import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book(123, "Luciana Litizzetto", "I dolori del giovane Programmatore"),
                new Book(4, "Super Mario", "Errori da non ripetere"),
                new Book(98, "Luigi Pirandino", "Uno, nessuno e diecimila bug"),
                new Book(33, "Roberto Roberti", "Come programmare in Java da zero"),
                new Book(76, "Piero Java", "Mille splendidi errori"),
                new Book(2, "Lavinia Pitoni", "Non si esce vivi dalle biblioteche"),
                new Book(235, "Luciana Litizzetto Jr.", "I dolori del vecchio Programmatore")
        };

        Library library = new Library(books);
        System.out.println(library.isBook(76));

        Book[] booksInLibrary = library.getBooks();
        System.out.println(booksInLibrary[0].getIndice() == 2);
        System.out.println(booksInLibrary[1].getIndice() == 4);
        System.out.println(booksInLibrary[2].getIndice() == 33);
        System.out.println(booksInLibrary[3].getIndice() == 76);
        System.out.println(booksInLibrary[4].getIndice() == 98);
        System.out.println(booksInLibrary[5].getIndice() == 123);
        System.out.println(booksInLibrary[6].getIndice() == 235);
    }
}