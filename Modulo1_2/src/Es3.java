public class Es3 {
    public static void main(String[] args) {
        int number = 0;
        System.out.println(!isPrime(number));
        number = 1;
        System.out.println(!isPrime(number));
        number = 2;
        System.out.println(isPrime(number));
        number = 17;
        System.out.println(isPrime(number));
        number = 631;
        System.out.println(isPrime(number));
        number = 634;
        System.out.println(!isPrime(number));
        number = 999;
        System.out.println(!isPrime(number));
        number = 997;
        System.out.println(isPrime(number));
    }

    private static boolean isPrime(int number) {
        //inserite qui il vostro codice
        if(number == 2){
            return true;
        }
        if(number%2==0 || number <= 1  ){
            return false;
        }
        for(int i = 3; i < Math.sqrt(number); i=i+2){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
