// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Utente utente1 = new Utente("Mario");
        Utente utente2 = new Utente("Luigi");
        Utente utente3 = new Utente("Wario");

        Interesse figa = new Interesse(1, "Figa");
        Interesse calcio = new Interesse(2, "Calcio");
        Interesse politica = new Interesse(3, "Politica");
        Interesse arte = new Interesse(4, "Arte");
        Interesse musica = new Interesse(5, "Musica");

        utente1.addInteresse(figa);
        utente1.addInteresse(calcio);
        utente1.addInteresse(politica);

        utente2.addInteresse(figa);
        utente2.addInteresse(arte);
        utente2.addInteresse(musica);

        utente3.addInteresse(figa);
        utente2.addInteresse(calcio);
        utente2.addInteresse(musica);

        Tinder tinder = new Tinder();
        tinder.addUtente(utente1);
        tinder.addUtente(utente2);
        tinder.addUtente(utente3);

        System.out.println(tinder.cercaAmico(utente1).getNome());
        
    }
}