import java.util.Arrays;
import java.util.Scanner;

public class Crucipuzzle {
    public static void main(String[] args) {
        char[][] matrice = {{'H', 'D', 'G', 'U', 'P', 'Y', 'S', 'P', 'A', 'O'},
                {'T', 'S', 'A', 'K', 'O', 'Y', 'O', 'L', 'P', 'S'},
                {'R', 'C', 'M', 'C', 'N', 'R', 'I', 'A', 'A', 'B'},
                {'I', 'O', 'B', 'A', 'I', 'S', 'C', 'T', 'L', 'A'},
                {'G', 'R', 'E', 'L', 'F', 'A', 'C', 'E', 'O', 'L'},
                {'L', 'F', 'R', 'A', 'L', 'L', 'U', 'S', 'I', 'E'},
                {'I', 'A', 'E', 'M', 'E', 'M', 'L', 'S', 'L', 'N'},
                {'A', 'N', 'T', 'A', 'D', 'O', 'C', 'A', 'G', 'A'},
                {'J', 'O', 'T', 'R', 'B', 'N', 'D', 'G', 'O', 'D'},
                {'L', 'Y', 'O', 'O', 'U', 'E', 'S', 'M', 'S', 'M'}};

        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci parola");
        String parola = sc.nextLine();

        System.out.println(myCrucy(matrice, parola));

    }

    private static boolean myCrucy(char[][] matrice, String parola) {
        StringBuilder newParola = new StringBuilder(parola.toUpperCase());
        for(int i = 0; i < matrice.length; i++){
            //CERCO RIGA
            String riga = String.valueOf(matrice[i]);
            if(riga.contains(newParola) || riga.contains(newParola.reverse())){
                return true;
            }

            //CERCO COLONNA
            String colonna = "";
            for(int j = 0; j < matrice.length; j++){
                colonna = colonna + matrice[j][i];
            }
            if(colonna.contains(newParola) || colonna.contains(newParola.reverse())){
                return true;
            }
        }
        return false;
    }
}
