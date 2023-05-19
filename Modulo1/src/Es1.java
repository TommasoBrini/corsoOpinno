import java.util.Scanner;

public class Es1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a:");
        int a=sc.nextInt();
        System.out.print("Enter b:");
        int b=sc.nextInt();
        computeValues(a, b);
    }

    private static void computeValues(int a, int b) {
        //inserite qui il vostro codice

        int add = a + b;
        System.out.println("Somma: " + add);

        int sott = a - b;
        System.out.println("Sottrazione: " + sott);

        int molt = a * b;
        System.out.println("Moltiplicazione: " + molt);

        double div = (double) a/b;
        System.out.println("Divisione: " + div);
    }
}