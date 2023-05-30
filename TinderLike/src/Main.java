import java.util.List;
import java.util.Map;
import java.util.Set;

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
        Interesse ballo = new Interesse(5, "ballo");
        Interesse canto = new Interesse(5, "canto");
        Interesse palestra = new Interesse(5, "Palestra");
        Interesse nuoto = new Interesse(5, "Nuoto");


        utente1.addInteresse(figa);
        utente1.addInteresse(calcio);
        utente1.addInteresse(musica);
        utente1.addInteresse(canto);
        utente1.addInteresse(ballo);

        utente2.addInteresse(figa);
        utente2.addInteresse(arte);
        utente2.addInteresse(musica);
        utente2.addInteresse(canto);
        utente2.addInteresse(ballo);

        utente3.addInteresse(figa);
        utente3.addInteresse(calcio);
        utente3.addInteresse(politica);
        utente3.addInteresse(canto);

        Tinder tinder = new Tinder();
        tinder.addUtente(utente1);
        tinder.addUtente(utente2);
        tinder.addUtente(utente3);

        System.out.println(tinder.cercaAmico(utente1).getNome());

        Set<Utente> max = tinder.utentiPiuSimili();
        System.out.println(max);

    }
}