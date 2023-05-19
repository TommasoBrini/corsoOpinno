import java.util.Scanner;

public class Es6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter index:");
        int index =sc.nextInt();
        fibonacci(index);
    }

    static void fibonacci(int index) {
        int prec = 0;
        int curr = 1;
        for(int i = 1; i < index; i++){
            int next = prec+curr;
            prec = curr;
            curr = next;
        }
        System.out.println("Fibonacci(" + index + ") = " + curr);
    }
}
