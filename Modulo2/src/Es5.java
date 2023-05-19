import java.util.Arrays;
import java.util.Scanner;

public class Es5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il moltiplicatore");
        int n = sc.nextInt();
        System.out.println("Inserisci la lunghezza dell'array");
        int m = sc.nextInt();
        System.out.println(Arrays.toString(getArray(n,m)));
    }

    private static int[] getArray(int n, int m) {
        int[] array = new int[m];
        for (int i = 0; i < m; i++){
            array[i] = i*n;
        }
        return array;
    }


}
