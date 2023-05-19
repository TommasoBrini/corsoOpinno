import java.util.Scanner;

public class Es2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string:");
        String a = sc.nextLine();
        stringReverse(a);
    }

    static void stringReverse(String s) {
        //inserite qui il vostro codice
        String[] array = s.split("");
        String result = "";
        for (String c:array){
            result = c + result;
        }
        System.out.println(result);
    }
}