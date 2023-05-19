import java.util.Scanner;

public class Es2 {
    public static void main(String[] args) {
        System.out.println("Inserisci una frase");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        countChar(str);
    }

    private static void countChar(String word) {
        int voc = 0, con = 0;
        word = word.toLowerCase();
        for(int i=0; i<word.length(); i++){
            char car = word.charAt(i);
            if(Character.isLetter(car)){
                if(String.valueOf(car).equals("a") || String.valueOf(car).equals("e") ||
                        String.valueOf(car).equals("i") || String.valueOf(car).equals("o") || String.valueOf(car).equals("u")){
                    voc++;
                } else {
                    con++;
                }
            }
        }
        System.out.println("Numero di vocali: " + voc);
        System.out.println("Numero di consonanti: " + con);


    }
}
