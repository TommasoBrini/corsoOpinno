import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //CREAZIONE PIATTAFORMA
        Piattaforma piattaforma = new Piattaforma();

        //CREAZIONE UTENTI
        Utente u1 = new Utente("Andrea", "Giordano", "@s1", "CKASLn");
        Utente u2 = new Utente("Mario", "Giordano", "@s2", "CKASLn");
        Utente u3 = new Utente("luigi", "Giordano", "@s3", "CKASLn");
        Utente u4 = new Utente("ferdinando", "Giordano", "@s4", "CKASLn");
        Utente u5 = new Utente("coletta", "Giordano", "@s5", "CKASLn");
        Utente u6 = new Utente("boni", "Giordano", "@s6", "CKASLn");
        Utente u7 = new Utente("meri", "Giordano", "@s7", "CKASLn");
        Utente u8 = new Utente("giulia", "Giordano", "@s8", "CKASLn");

        //AGGIUNTA UTENTI
        piattaforma.addUtente(u1);
        piattaforma.addUtente(u2);
        piattaforma.addUtente(u3);
        piattaforma.addUtente(u4);
        piattaforma.addUtente(u5);
        piattaforma.addUtente(u6);
        piattaforma.addUtente(u7);
        piattaforma.addUtente(u8);
        //STAMPA UTENTI
        System.out.println(piattaforma.getUtenti().values());

        //APPROVA HOST
        piattaforma.approvaHost(u1, 1);
        u1 = piattaforma.getHostById(1);
        piattaforma.approvaHost(u2, 2);
        u2 = piattaforma.getHostById(2);
        piattaforma.approvaHost(u3, 3);
        u3 = piattaforma.getHostById(3);
        piattaforma.approvaHost(u4, 4);
        u4 = piattaforma.getHostById(4);

        //CREAZIONE ABITAZIONI
        Abitazione a1 = new Abitazione(0, "villa", "viale1", 1, 2, 3, (Host) u1);
        Abitazione a2 = new Abitazione(1, "villa", "viale1", 1, 2, 3, (Host) u1);
        Abitazione a3 = new Abitazione(2, "villa", "viale1", 1, 4, 3, (Host) u2);
        Abitazione a4 = new Abitazione(3, "villa", "viale1", 1, 4, 3, (Host) u4);

        //AGGIUNTA ABITAZIONI
        piattaforma.addAbitazione(a1);
        piattaforma.addAbitazione(a2);
        piattaforma.addAbitazione(a3);
        piattaforma.addAbitazione(a4);

        //TEST getAbitazioni(int codHost)
        System.out.println("*** ABITAZIONI DELL'UTENTE " + u1 + " ***");
        System.out.println(piattaforma.getAbitazione(((Host) u1).getCodHost()));

        //PUBBLICA ABITAZIONI IN PRENOTABILI
        piattaforma.pubblicaAbitazione(a1, 23, LocalDate.of(2020, 3, 12), LocalDate.of(2020, 3, 12));
        a1 = piattaforma.getAbitazionePrenotabile(a1.getIdUnivoco());
        piattaforma.pubblicaAbitazione(a2, 23, LocalDate.of(2021, 3, 12), LocalDate.of(2021, 3, 12));
        a2 = piattaforma.getAbitazionePrenotabile(a2.getIdUnivoco());
        piattaforma.pubblicaAbitazione(a3, 23, LocalDate.of(2022, 3, 10), LocalDate.of(2022, 3, 12));
        a3 = piattaforma.getAbitazionePrenotabile(a3.getIdUnivoco());
        piattaforma.pubblicaAbitazione(a4, 23, LocalDate.of(2022, 2, 10), LocalDate.of(2022, 2, 12));
        a4 = piattaforma.getAbitazionePrenotabile(a4.getIdUnivoco());

        //CREAZIONE PRENOTAZIONI
        Prenotazione p1 = new Prenotazione(1, LocalDate.of(2020, 3, 12), LocalDate.of(2020, 3, 12), (AbitazionePrenotabile) a1, u5, 500);
        Prenotazione p2 = new Prenotazione(2, LocalDate.of(2021, 3, 12), LocalDate.of(2021, 3, 12), (AbitazionePrenotabile) a2, u5, 500);
        Prenotazione p3 = new Prenotazione(3, LocalDate.of(2022, 3, 10), LocalDate.of(2022, 3, 12), (AbitazionePrenotabile) a3, u8, 500);
        Prenotazione p4 = new Prenotazione(4, LocalDate.of(2022, 2, 10), LocalDate.of(2022, 2, 12), (AbitazionePrenotabile) a4, u6, 500);

        //AGGIUNTA PRENOTAZIONI
        piattaforma.addPrenotazione(p1);
        piattaforma.addPrenotazione(p2);
        piattaforma.addPrenotazione(p3);
        piattaforma.addPrenotazione(p4);

        //STAMPA lastPrenotazione() DELL'UTENTE u5
        System.out.println("*** ULTIMA PRENOTAZIONE DI " + u5 + " ***");
        System.out.println(piattaforma.lastPrenotazione(u5.getEmail()));

        //STAMPA LA ABITAZIONE PIù GETTONATA
        System.out.println("*** ABITAZIONE PIù GETTONATA ***");
        System.out.println(piattaforma.abitazioneGettonata());

        //STAMPA GLI HOST CON PIù PRENOTAZIONI
        System.out.println("*** HOST PIù GETTONATI ***");
        System.out.println(piattaforma.hostGettonato());

        //STAMPA TUTTI I SUPERHOST
        System.out.println("*** SUPER HOST ***");
        piattaforma.rendiSuperHost(((Host) u4).getCodHost());
        System.out.println(piattaforma.getSuperHost());

        //OTTENERE I 5 UTENTI CON PIù GIORNI PRENOTATI
        System.out.println("*** UTENTI CON PIù GIORNI PRENOTATI ***");
        piattaforma.getTopUtenti();


        //TEST mediaPostiLetto()
        System.out.println("*** MEDIA POSTI LETTO ***");
        System.out.println(piattaforma.mediaPostiLetto());

    }
}