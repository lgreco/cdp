import java.util.Random;

/**
 * This class is an example of tidying up "monolithic" code. We started with
 * class SillyArraySorting that contained only the main method, in which we
 * implemented a simple Bubble sort algorithm. The code there contained many
 * repeatitions. This class breaks that monolithic code is several reusable
 * components.
 *
 * The class comprises two constructors, an overloaded method in two variations
 * to print an array, the bubble sorting method, and the main method.
 *
 */

public class SillyArraySortingImproved {

    private final int rows;     /* number of rows in array */
    private final int columns;  /* number of columns in array */
    private final int minValue; /* smallest value of an element in array */
    private final int maxValue; /* largest value of an element in array */
    private final int seed;     /* random number generator seed */

    private double executeTime; /* CPU time required to sort the array */

    /**
     * Default constructor sets up the parameters to create a 3x3 array
     * filled with two-digit integer numbers.
     */
    public SillyArraySortingImproved() {
        rows = 200;
        columns = 200;
        minValue = 10;
        maxValue = 90;
        seed = 45;
    }

    /**
     * Full constructor.
     * @param rows number of rows in array
     * @param columns number of columns in array
     * @param maxValue smallest value for any element in array
     * @param minValue largest value for any element in array
     * @param seed random number generator seed
     */
    public SillyArraySortingImproved(int rows, int columns, int maxValue, int minValue, int seed) {
        this.rows = rows;
        this.columns = columns;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.seed = seed;
    }

    /**
     * This method populates an 2D integer array with random numbers
     * @return random-valued 2D int array
     */
    public int[][] createPopulate() {
        int[][] a = new int[rows][columns];
        Random r = new Random(seed);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //a[i][j] = minValue + r.nextInt(maxValue);
                a[i][j] = rows*columns- (i*columns+j);
            }
        }
        return a;
    }

    /**
     * This variation of print2dArray produces a simple printout
     * @param a two-dimensional array to print
     */
    public void print2DArray(int[][] a) {
        int numberOfDigits = 2 + (int) Math.ceil(Math.log10(maxValue));
        String formatString = "%" + numberOfDigits +"d";
        System.out.println("\nInput array:\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf(formatString, a[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * This variation of print2D prints only the time to sort the sort the
     * array and the size of the array. This is useful for larger arrays that
     * may occupy too much space on the console. We skip printing the actual
     * array and instead we print their size and the CPU time for the sort.
     */
    public void print2DArray() {
        System.out.printf("\nIt took approximately %.3f msec to sort an %d x %d array",executeTime, rows, columns);
    }

    public int[][] bubbleSort(int[][] a) {
        long endTime, startTime;
        int arraySize = rows*columns;
        startTime=System.nanoTime();
        boolean swapping = true;
        int linearFromHere, linearIndex;
        int temp, currentI, currentJ, nextI, nextJ;
        linearFromHere = 0;
        while (swapping) {
            swapping = false;
            linearFromHere = linearFromHere + 1;
            for (linearIndex = 0; linearIndex < arraySize - linearFromHere; linearIndex++) {
                currentJ = linearIndex % columns;             // Refolding a linear array to a row-major ordered 2D
                currentI = (linearIndex - currentJ)/columns;  // array is accomplished by
                nextJ = (linearIndex + 1 ) % columns;         //  j = k % M ...... k: linear index, M # of columns
                nextI = (linearIndex + 1 - nextJ)/columns;    //  i = (k-j)/M .... (i,j) 2D position.
                if (a[currentI][currentJ] > a[nextI][nextJ]) {
                    temp = a[currentI][currentJ];
                    a[currentI][currentJ] = a[nextI][nextJ];
                    a[nextI][nextJ] = temp;
                    swapping = true;
                }
                //swapping = true;
            }
        }
        endTime = System.nanoTime();
        executeTime = ((double)(endTime-startTime))/1000000.0;
        return a;
    }

    public static void main(String[] args) {

        SillyArraySortingImproved demo = null;
        /**
         * Local variable to determine whether or not to print the full
         * array or a summary of it. If 2D array has more than cutoff
         * elements, we only print a summary of it.
         */
        int cutoff = 0;

        if (args.length == 0) {
            demo = new SillyArraySortingImproved();
            cutoff = 100;
        }
        else if (args.length == 5) {                   // This block needs some more work,
            int rows = Integer.parseInt(args[0]);      // specifically to validate that
            int columns = Integer.parseInt(args[1]);   // args[] can be converted to
            int minValue = Integer.parseInt(args[2]);  // integers. Right now the code
            int maxValue = Integer.parseInt(args[3]);  // assumes that everything coming
            int seed = Integer.parseInt(args[4]);      // through the command line is a
            cutoff = Integer.parseInt(args[5]);        // valid integer number.
            demo = new SillyArraySortingImproved(rows, columns, minValue, maxValue, seed);
        } else {
            demo = new SillyArraySortingImproved();
            cutoff = 100;
        }

        SillyArraySortingImproved d = new SillyArraySortingImproved();
        int a[][] = demo.createPopulate();
        if (demo.rows*demo.columns < cutoff)
            demo.print2DArray(a);
        a = demo.bubbleSort(a);
        if (demo.rows*demo.columns < cutoff) {
            demo.print2DArray(a);
            demo.print2DArray();
        }
        else
            demo.print2DArray();
    }
}