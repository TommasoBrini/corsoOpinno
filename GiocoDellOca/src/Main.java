// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore("Luigi");
        Giocatore g2 = new Giocatore("Mario");
        Giocatore[] gioc = {g1, g2};

        GiocoDellOca gioco = new GiocoDellOca(20, gioc);
        gioco.giocaUnTurno();
    }
}