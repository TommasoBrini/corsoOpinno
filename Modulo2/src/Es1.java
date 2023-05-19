import java.util.Scanner;
public class Es1 {

    public static void main(String[] args) {
        System.out.println("Inserisci un numero: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(myQuadrato(num));
    }

    private static int myQuadrato(int num) {
        int potenza = 0;
        for (int i = 1; i < num*2; i += 2) {
            System.out.println(i);
            potenza += i;
        }
        return potenza;
    }
}
