/**
 * A simple class with a method to print the Pythagorean Table (PT) for the first
 * 10 numbers (excluding 0). The PT is generally a table with N rows and N columns
 * in which each box is the product of the corresponding row and column number.
 *
 * The notion of a PT can be expanded to show other mathematical operations, but
 * for now we'll keep it to multiplication.
 */
public class Pythagoras {

    // Size of table
    private static final int N = 10;

    /**
     * Method to produce a simple table.
     *
     * Ideas for possible homework assignments:
     * * parameterize the method
     * * add header row and count column
     * * use method as blueprint for other ops, e.g.
     *   * division
     *   * addition and mod
     *   * polar form of composite numbers
     */
    public static void pythagoreanTable() {
        // Outer loop, creates N rows, starting from 1
        for (int row = 1; row <= N; row++ ) {
            // Inner loop, creates N entries per row, starting from 1
            for (int column = 1; column <= N; column++) {
                // The product of current row and column
                int rowTimesColumn = row * column;
                // printf allows us to do some nicely formatted printing.
                System.out.printf("%5d" , rowTimesColumn);
                /*
                           printf  accepts two or more arguments. The first
                                   argument is a formatting directive. The
                                   remaining are the items we wish to print.

                                   A formatting directive is a string that starts
                                   with the % symbol. The rest tells the program
                                   how to format the data following the string (in
                                   this case, the rowTimesColumn integer variable).

                                   %5d has two formatting components:
                                   the designation d telling the program to treat
                                   the corresponding data as an integer number and
                                   the value 5 instructing the program to reserve
                                   5 places for that number. Try changing 5 to 7
                                   or 3 and see what happens.

                                   For a technical review of Java's Formatter:
                                   https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
                 */
            }
            // Break line for the next row. Try omitting this and see what happens.
            System.out.println();
        }
    } // method pythagoreanTable

    // driver method (aka main) to run code
    public static void main(String[] args) {
        pythagoreanTable();
    }
}
