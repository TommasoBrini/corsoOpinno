import java.util.Arrays;
import java.util.Scanner;

public class Es4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string:");
        String a=sc.nextLine();
        System.out.print("Enter string:");
        String b=sc.nextLine();
        System.out.print("Enter string:");
        String c=sc.nextLine();
        replaceIntruder(a, b, c);
    }

    private static void replaceIntruder(String a, String b , String c) {
        //inserite qui il vostro codice
        String[] array = c.split(" ");
        array[1] = array[1].replaceAll(a, b);
        String prv = String.join(" ", array);
        System.out.println(prv);
    }

}
