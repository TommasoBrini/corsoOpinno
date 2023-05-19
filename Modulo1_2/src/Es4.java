public class Es4 {
    public static void main(String[] args) {
        System.out.println(factorial(1) == (0));
        System.out.println(factorial(2) == (2));
        System.out.println(factorial(5) == (120));
        System.out.println(factorial(10) == (3628800));
        System.out.println(factorial(20) == 2432902008176640000L);
    }

    private static long factorial(int n) {
        //inserite il vostro codice qui
        long count = 1;
        if (n==1){
            return 0;
        }
        for(int i=2; i<n+1; i++){
            count = count*i;
        }
        return count;
    }
}
