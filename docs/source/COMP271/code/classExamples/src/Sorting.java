import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Sorting {

    /**
     * Sorts an array of integers using the selection algorithm
     * @param a array to sort
     * @return sorted array
     */
    public static int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int indexOfSmallest = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[indexOfSmallest]) {
                    indexOfSmallest = j;
                }
            }
            swap(a,i,indexOfSmallest);
        }
        return a;
    }

    public static void swap(int[] a, int thisPosition, int thatPosition) {
        int temp = a[thisPosition];
        a[thisPosition] = a[thatPosition];
        a[thatPosition] = temp;
    }

    public static int[] mergeSort(int[] a) {
        if (a.length > 1) {
            int[] leftHalf = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] rightHalf = Arrays.copyOfRange(a, a.length / 2, a.length);
            mergeSort(leftHalf);
            mergeSort(rightHalf);
            merge(a, leftHalf,rightHalf);
        }
        return a;
    }

    public static void merge(int[] result, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < result.length; i++) {
            if (rightIndex >= right.length || (leftIndex < left.length && left[leftIndex] <= right[rightIndex])) {
                result[i] = left[leftIndex];
                leftIndex++;
            } else {
                result[i] = right[rightIndex];
                rightIndex++;
            }
        }
    }

    public static void randomizeArray(int[] a) {
        Random r = new Random();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n);
        }
    }

    public static void main(String[] args) {
        int inputArray[], outputArray[];
        long timeStart, timeFinish;
        System.out.println("Array     Selection     Merge");
        System.out.println("size      sort          sort");
        System.out.println("N         time          time");
        for (int N=2; N < 1000000; N=N*2) {
            inputArray = new int[N];
            outputArray = new int[N];
            randomizeArray(inputArray);
            timeStart = System.currentTimeMillis();
            outputArray = selectionSort(inputArray);
            timeFinish = System.currentTimeMillis();
            long t1 = timeFinish-timeStart;
            timeStart = System.currentTimeMillis();
            outputArray = mergeSort(inputArray);
            timeFinish = System.currentTimeMillis();
            long t2 = timeFinish-timeStart;
            System.out.printf("\n%7d     %5d     %5d", N,t1,t2);
        }
    }
}
