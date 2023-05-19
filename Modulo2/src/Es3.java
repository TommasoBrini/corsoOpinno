import java.util.Scanner;

public class Es3 {
    public static void main(String[] args) {
        System.out.println("Inserisci i secondi!");
        Scanner sc = new Scanner(System.in);
        long sec  = sc.nextLong();
        contaSecondi(sec);
    }

    private static void contaSecondi(long sec) {
        long days = sec / (24 * 3600);
        long hours = (sec % (24 * 3600)) / 3600;
        long min = (sec % 3600) / 60;
        sec = sec % 60;

        String risultato = "";
        if (days > 0) {
            risultato += days + " giorn" + (days > 1 ? "i" : "o") + ", ";
        }
        if (hours > 0) {
            risultato += hours + " or" + (hours > 1 ? "e" : "a") + ", ";
        }
        if (min > 0) {
            risultato += min + " minut" + (min > 1 ? "i" : "o") + ", ";
        }
        risultato += sec + " second" + (sec > 1 ? "i" : "o");

        System.out.println(risultato);
    }
}

