/**
 * A simple demo with nested loops. This class improves on the previous
 * class NestedLoops, by providing two class variables to control WIDTH
 * and HEIGHT of the shape we wish to draw. This way we can draw any
 * rectilinear shape and not just square-ish ones.
 */
public class NestedLoopsRefined {

    public static final int WIDTH = 20;
    public static final int HEIGHT = 10;
    public static final String SYMBOL = ".";

    /**
     * Method that prints a square pattern of stars using nested loops.
     */
    public static void square() {

        for (int lineCount = 0; lineCount < HEIGHT; lineCount++ ) { // how many lines to print

            for (int symbolCount = 0; symbolCount < WIDTH; symbolCount++ ) { // how many characters to print in this line
                System.out.print(SYMBOL);
            }

            System.out.println(); // try to comment this out, see what happens.
        }
    } // method square

    public static void main(String[] args) {
        square(); // draw the square shape
    }

} // class NestedLoopsRefined
