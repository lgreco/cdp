/**
 * A simple demonstration of symmetric patterns with loops. The class
 * focuses on the FOR-loop statement. The statement has 1+3 parts:
 * The keyword "for", followed by the initialization, termination and
 * increment parts:
 *
 * for (initialization; termination; increment) {
 *     // code to repeat
 * }
 *
 * The for-loop repeats the code that it encloses in curly brackets.
 *
 * The number of repetitions is determined by the values of the
 * initialization, termination, and increment parts. These three
 * parts constitute a counting process. The counting starts with
 * the value specified in initialization. It stops when the initialized
 * variable (called the "loop variable") no longer satisfies the
 * termination part. The loop variable changes its value according to
 * the increment part; that value is assessed by the termination part
 * every time it changes.
 *
 * The loop:
 *
 *   for ( int i = 2; i < 32; i = i*2 )
 *
 * start counting at 2 and continues to increment the loop variable
 * by doubling it as long as i<32. Here're the steps:
 *
 * Count     value     does i satisfy         increment
 * value     of i      the termination        i to
 *
 * first       2       yes ( 2 < 32)            4
 * second      4       yes ( 4 < 32)            8
 * third       8       yes ( 8 < 32)           16
 * fourth     16       yes (16 < 32)           32
 * fifth      32       no
 *
 * So the counting above will complete only four steps.
 *
 */
public class Triangles {

    /*
     A variable to tell every method in the program
     how many lines we want to use. This way, we can
     change the number of lines in one place.
     */
    private static final int NUMBER_OF_LINES = 5;

    /**
     * Method to print a right-angle triage with its
     * hypotenuse to the right.
     */
    public static void right() {
        for (int i = 0; i < NUMBER_OF_LINES; i = i+1 ) {
            /*
            The   repeat(M)   method makes M copies of the string
            it is attached to. For example,
            "#".repeat(5) is the same as "#####"
             */
            System.out.println("*".repeat( i+1 ));
        }
    } // method right

    /**
     * Method to print a right-angle triangle with its
     * hypotenuse to the left.
     */
    public static void left() {
        /*
        From now on we will begin to use the increment operator (++)
        instead of the assignment i = i + 1.
         */
        for (int i = 1; i <= NUMBER_OF_LINES; i++ ) {
            System.out.println(" ".repeat(NUMBER_OF_LINES -i)+"*".repeat(i));
        }
    } // method left

    public static void equilateral() {
        for (int i = 0; i < NUMBER_OF_LINES; i++ ) {
            System.out.println(" ".repeat((NUMBER_OF_LINES+1)-i)+"*".repeat(2*i+1));
        }
    }

    public static void main(String[] args) {
        right();
        System.out.println(); // empty line for visual separation
        left();
        System.out.println(); // empty line for visual separation
        equilateral();
    }
}