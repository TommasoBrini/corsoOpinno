import java.util.Arrays;

public class TestClassifica {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore(1, "Cristiano", "Ronaldo");
        Giocatore g2 = new Giocatore(2, "Cristiano", "Ronaldo");
        Giocatore g3 = new Giocatore(3, "Cristiano", "Ronaldo");
        Giocatore g4 = new Giocatore(4, "Cristiano", "Ronaldo");
        Giocatore g5 = new Giocatore(5, "Cristiano", "Ronaldo");

        Giocatore[] giocatori = {g1, g2, g3, g4, g5};

        Squadra squadra1 = new Squadra(1, "Milan", giocatori);
        Squadra squadra2 = new Squadra(1, "Juve", giocatori);
        Squadra squadra3 = new Squadra(1, "Inter", giocatori);
        Squadra squadra4 = new Squadra(1, "Roma", giocatori);
        Squadra squadra5 = new Squadra(1, "Napoli", giocatori);

        Squadra[] squadre = {squadra1, squadra2, squadra3, squadra4, squadra5};

        Classifica campionato = new Classifica(squadre);

        System.out.println("Squadre partecipanti: ");
        System.out.println(Arrays.toString(campionato.getClassifica()));

        //INSERISCO PARTITE
        campionato.esitoPartita(squadra1, 3, squadra2, 0);
        campionato.esitoPartita(squadra5, 1, squadra4, 1);
        campionato.esitoPartita(squadra3, 2, squadra2, 3);
        campionato.esitoPartita(squadra1, 1, squadra5, 0);
        campionato.esitoPartita(squadra4, 2, squadra3, 1);

        System.out.println("CLASSIFICA: ");
        System.out.println(Arrays.toString(campionato.getClassifica()));
        System.out.println("MIGLIOR ATTACCO");
        System.out.println(campionato.getMigliorAttacco() + ", gol: " + campionato.getMigliorAttacco().getGolFatti());
        System.out.println("PEGGIOR DIFESA");
        System.out.println(campionato.getPeggiorDifesa() + ", gol: " + campionato.getPeggiorDifesa().getGolSubiti());
    }
}
