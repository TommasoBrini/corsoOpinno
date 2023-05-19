import java.util.Arrays;

public class Es4 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int[] newArray = raddoppiaDispari(array);
        System.out.println(Arrays.toString(newArray));
    }

    private static int[] raddoppiaDispari(int[] array) {
        int[] newArray = array;
        for(int i = 0; i < array.length; i++){
            int el = array[i];
            if(el%2!=0){
                el = el*2;
            }
            newArray[i] = el;
        }
        return newArray;
    }


}
