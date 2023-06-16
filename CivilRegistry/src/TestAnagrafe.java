import java.util.List;

public class TestAnagrafe {
    public static void main(String[] args) {
        Anagrafe ufficio = new Anagrafe();

        // Esempi di utilizzo
        Persona persona1 = new Persona("Mario", "Rossi", 30, "ABC123", "Via Roma 1");
        Persona persona2 = new Persona("Luigi", "Bianchi", 40, "DEF456", "Via Verdi 2");
        Persona persona3 = new Persona("Maria", "Verdi", 35, "GHI789", "Via Roma 3");

        ufficio.addPersona(persona1);
        ufficio.addPersona(persona2);
        ufficio.addPersona(persona3);

        System.out.println("Lista persone:");
        ufficio.persone.forEach(p -> System.out.println(p.getNome() + " " + p.getCognome()));

        System.out.println("\nRimozione persona con codice fiscale ABC123");
        ufficio.removePersona("ABC123");

        System.out.println("Lista persone dopo rimozione:");
        ufficio.persone.forEach(p -> System.out.println(p.getNome() + " " + p.getCognome()));

        System.out.println("\nPersone con nome che inizia per 'Ma':");
        List<Persona> personePerNome = ufficio.getPersona("Ma");
        personePerNome.forEach(p -> System.out.println(p.getNome() + " " + p.getCognome()));

        System.out.println("\nTre persone più anziane:");
        List<Persona> trePersonePiuAnziane = ufficio.getPersoneAnziane();
        trePersonePiuAnziane.forEach(p -> System.out.println(p.getNome() + " " + p.getCognome() + " (" + p.getEta() + ")"));

        System.out.println("\nIndirizzi delle persone di nome 'Maria':");
        List<String> indirizziPerNome = ufficio.getIndirizzi("Maria");
        indirizziPerNome.forEach(System.out::println);
    }
}