/**
 * A class with a few loop examples.
 */
public class ASimpleProblem {

    /**
     * A simple method to compute the sum of M integer numbers
     * beginning from N, i.e.,
     *   N + (N+1) + (N+2) + ... + (N+M-1)
     *   \____________   ________________/
     *                 \/
     *                 M terms
     * @param N number to start with
     * @param M how many numbers to add
     */
    public static void rollingSum(int N, int M) {
        int sum = 0; // initialize sum variable
        for (int i = N; i < N+M ; i++) { // loop from N to N+M-1
            sum = sum+i;
        }
        // report result
        System.out.printf("\n\nSum of the first %d integers beginning at %d = %d\n\n", M,N,sum);
    } // method rollingSum

    /**
     * A simple pattern demonstrating nested and tandem loops
     *
     * ****||
     *  ***||*
     *   **||**
     *    *||***
     *     ||****
     *
     * @param N number of lines to print
     */
    public static void pattern(int N) {
        for (int i = 0; i < N; i++) {
            for ( int k = 0; k < i; k++ ) { System.out.print(" "); } // print k spaces
            for ( int k = 0; k < N-1-i; k++ ) { System.out.print("*"); } // print (N-1)-k stars
            System.out.print("||"); // print 2 bars
            for ( int k = 0; k <i; k++ ) { System.out.print("*"); }// print k stars
            System.out.println();
        }
    } // method pattern

    /**
     * A weird restaurant with 36 tables, arranged in 6 rows of 6 tables each,
     * where each table accommodates 4 customers.
     */
    public static void restaurantTables() {
        int tableCount = 1;
        for ( int row = 1; row <7; row++ ) {
            for ( int column = 1; column < 7; column ++ ) {
                System.out.printf("Table %2d is in row %d, column %d, with guests:", tableCount, row, column);
                for ( int guest = 1 ; guest < 5 ; guest ++ ) {
                    System.out.printf("%2d", guest);
                }
                System.out.println();
                tableCount = tableCount+1;
            }
        }
    } // method restaurantTables

    /**
     * Print CPD beats (including those in non-existent 13th district!)
     */
    public static void beats() {
        for ( int district = 0; district < 26; district++) {
            for ( int beat = 1; beat < 40; beat++ ) {
                System.out.printf("Car number %02d%02d \n",district,beat);
            }
        }
    } // method beats

    /**
     * Four nested loops show how performance is affected
     * when we switch N from 100 to 1000. The inner-most
     * loop executes NxNxNxN time
     * @param N how many times to execute each loop
     */
    public static void complexityDemo(int N) {
        for ( int i = 0; i < N; i++ ) {
            for ( int j = 0; j < N; j++ ) {
                for ( int k = 0; k < N; k++ ) {
                    for ( int l = 0; l < N; l++ ) {
                        // do something cool
                    }
                }
            }
        }
    } // method complexityDemo

    /** Driver method */
    public static void main(String[] args) {
        // rollingSum(0,5);
        // System.out.println();
         pattern(5);
        // System.out.println();
        // restaurantTables();
        // beats();
    }
}


