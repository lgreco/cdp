/**
 * A simple demo with nested loops
 */
public class NestedLoops {

    public static final int NUMBER_OF_LINES = 10;
    public static final String SYMBOL = ". ";

    /**
     * Method that prints a square pattern of stars using nested loops.
     */
    public static void square() {

        for (int lineCount = 0; lineCount < NUMBER_OF_LINES; lineCount++ ) { // how many lines to print
            for (int symbolCount = 0; symbolCount < NUMBER_OF_LINES; symbolCount++ ) { // how many characters to print in this line
                System.out.print(SYMBOL);
            }
            System.out.println(); // try to comment this out, see what happens.
        }
    } // method square

    public static void main(String[] args) {
        square(); // draw the square shape
    }

} // class NestedLoops
