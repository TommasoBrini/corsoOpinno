import java.util.Arrays;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        final int smallDimension = 100;
        final int midDimension = 1000;
        final int bigDimension = 100000;

        int[] arraySmall = randomArray(smallDimension);
        int[] arrayMid = randomArray(midDimension);
        int[] arrayBig = randomArray(bigDimension);
        int[] arrayMidWorst = SpecialCase(midDimension, false);
        int[] arrayMidBest = SpecialCase(midDimension, true);

        System.out.println("Insertion Sort");
        System.out.println("-Small dimension time = " + insertionSort(arraySmall));
        System.out.println("-Mid dimension time = " + insertionSort(arrayMid));
        System.out.println("-Worst Mid dimension time = " + insertionSort(arrayMidWorst));
        System.out.println("-Best Mid dimension time = " + insertionSort(arrayMidBest));
        System.out.println("-Big dimension time = " + insertionSort(arrayBig));


        System.out.println("\n BubbleSort");
        System.out.println("-Small dimension time = " + bubbleSort(arraySmall));
        System.out.println("-Mid dimension time = " + bubbleSort(arrayMid));
        System.out.println("-Worst Mid dimension time = " + bubbleSort(arrayMidWorst));
        System.out.println("-Best Mid dimension time = " + bubbleSort(arrayMidBest));
        System.out.println("-Big dimension time = " + bubbleSort(arrayBig));
    }

    private static long insertionSort(int[] code) {
        long count = 0;
        int[] array = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            array[i] = code[i];
        }
        long start = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > value) {
                array[j + 1] = array[j];
                j--;
                array[j + 1] = value;
                count++;
            }
        }
        long end = System.nanoTime();
        end = end - start;
        return end;
    }

    private static long bubbleSort(int[] code) {
        long contatore = 0;
        int[] array = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            array[i] = code[i];
        }
        boolean scambio = true;
        long start = System.nanoTime();
        while (scambio) {
            scambio = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int value = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = value;
                    scambio = true;
                    contatore++;
                }
            }

        }
        long end = System.nanoTime();
        end = end - start;
        return end;

    }

    private static int[] SpecialCase(int size, boolean caseSet) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            if (caseSet) {
                array[i] = i;
            } else {
                array[i] = size - i;
            }
        }
        return array;
    }

    private static int[] randomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}