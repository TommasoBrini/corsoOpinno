// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Tripleton trip = Tripleton.getIstance();
        Tripleton trip2 = Tripleton.getIstance();
        Tripleton trip3 = Tripleton.getIstance();
        Tripleton trip4 = Tripleton.getIstance();
        Tripleton trip5 = Tripleton.getIstance();
        Tripleton trip6 = Tripleton.getIstance();
        Tripleton trip7 = Tripleton.getIstance();

        System.out.println(Tripleton.getTripleton());

    }
}