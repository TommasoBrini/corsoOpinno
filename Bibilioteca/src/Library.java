import java.util.Arrays;
import java.util.Comparator;

public class Library {
    private Book[] books;

    public Library (Book[] books){
        this.books = books;
    }
    
    public boolean isBook(int ind){
        for (Book book : books) {
            if(book.getIndice() == ind){
                return true;
            }
        }
        return false;
    }

    public Book[] getBooks() {
        Book[] booksCopy = books;
        Book[] booksOrd = new Book[books.length];
        int count = 0;
        while(count < books.length){
            int i = 1000000;
            for (Book book : booksCopy) {
                if(book.getIndice() < i){
                    booksOrd[count] = book;
                    i = book.getIndice();
                }
            }
            for (int j = 0; j < booksCopy.length; j++){
                if(booksCopy[j].getIndice()==i){
                    booksCopy[j] = new Book(1000000, "VUOTO", "VUOTO");
                }
            }
            count++;
        }
        //Arrays.sort(books, Comparator.comparing(Book::getIndice));
        return booksOrd;
    }
}
