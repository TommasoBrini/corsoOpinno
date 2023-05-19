public class Es6 {

    /*
     * Scrivere un programma che, data in input una stringa s, restituisca true se s è palindroma, false
altrimenti
     *
     */

    public static void main(String[] args) {
        System.out.println(isPalindrome("c"));
        System.out.println(isPalindrome("ciic"));
        System.out.println(isPalindrome("aaaa"));
        System.out.println(!isPalindrome("absca"));
        System.out.println(!isPalindrome("abbaa"));
        System.out.println(isPalindrome("zzzzz"));
        System.out.println(isPalindrome("zzczz"));
        System.out.println(isPalindrome("aabbaa"));
    }

    private static boolean isPalindrome(String s) {
        //inserite qui il vostro codice
        int l = s.length() - 1;
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(l)){
                return false;
            }
            l--;
        }
        return true;
    }
}