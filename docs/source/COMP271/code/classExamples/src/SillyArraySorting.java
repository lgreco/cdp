import java.util.Random;

/**
 * This class sorts a 2D array with 3x3
 */
public class SillyArraySorting {

    private int N;
    private int M;
    private int minValue;
    private int maxValue;

    public SillyArraySorting() {
        N = 3;
        M = 3;
        minValue = 10;
        maxValue = 90;
    }

    public SillyArraySorting(int N, int M, int minValue, int maxValue) {
        this.N = N;
        this.M = M;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * Method to print array
     */
    public void print2DArray(int[][] a) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] createArray() {
        Random r = new Random();
        int[][] a = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = minValue + r.nextInt(maxValue);
            }
        }
        return a;
    }

    public int[][] bubbleSort(int[][] a) {
        // sort the array
        boolean swapping = true;
        int linearFromHere, linearIndex;
        int temp, currentI, currentJ, nextI, nextJ;

        linearFromHere = 0;

        while (swapping) {
            swapping = false;
            linearFromHere = linearFromHere + 1;

            for (linearIndex = 0; linearIndex < N*M - linearFromHere; linearIndex++) {
                currentI = linearIndex / M;
                currentJ = linearIndex % N;
                nextI = (linearIndex + 1) / M;
                nextJ = (linearIndex + 1) % N;
                 System.out.println("Linear position " + linearIndex +
                        " --> ("  + currentI + ", " + currentJ  +
                        "); next (" + nextI + ", " + nextJ +")");
                if (a[currentI][currentJ] > a[nextI][nextJ]) {
                    temp = a[currentI][currentJ];
                    a[currentI][currentJ] = a[nextI][nextJ];
                    a[nextI][nextJ] = temp;
                    swapping = true;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        // .... to read args[] and act accordingly
        // if (args.length == 0 ) --> use default constructor;
        // if (args.length == 4 ) --> ... validate the args, then pass them to full constructor
        SillyArraySorting demo = new SillyArraySorting(2,3,10,90);
        int[][] a = demo.createArray();
        demo.print2DArray(a);
        a = demo.bubbleSort(a);
        demo.print2DArray(a);
    }
}
