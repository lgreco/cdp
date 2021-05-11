import java.io.File;
import java.util.Scanner;

/** Sample solution for Exam 3 */

public class Exam3 {

    /** Abstractions for the arithmetic characters we expect to see
     * and narrative we wish to print */
    private static final String ADD = "+",      PLUS = "plus";
    private static final String SUBTRACT = "-", MINUS = "minus";
    private static final String MULTIPLY = "*", TIMES = "times";

    /**
     * Driver method, aka main. Declares a scanner object, then matches it to
     * the input file, and passes it to the processing method.
     */
    public static void main(String[] args) {
        Scanner s = null; // Declare scanner
        File numbersFile = new File("numbers.txt");
        try { // attempt to connect
            s = new Scanner(numbersFile);
        } catch (Exception e) {
            System.out.println("File not found.");
        }
        printSum(s); // call processing method
    } // method main

    /**
     * Processing method that parses a file passed as a scanner object and
     * narrates the arithmetic operations found in that file. The method
     * prints operation and operand for each of the three possible operations
     * then updates the accumulator and prints its value after the if-block.
     *
     * The narrative has the following format:
     *
     *    %d %s %d is %d
     *    ^  ^  ----^---
     *    |  |      |
     *    |  |      +-------------> this part comprises the value read from the file
     *    |  |                      and the updated value of the accumulator, and it is
     *    |  |                      reported after the if-block that determines which
     *    |  |                      arithmetic operations to perform.
     *    |  |
     *    |  +---------------> this part comprises the arithmetic action (based on
     *    |                    the statics PLUS, MINUS, TIMES, and is determined
     *    |                    during the if-block, at the same time we update the
     *    |                    value of the accumulator.
     *    |
     *    +-------------> this part comprises the current value of the
     *                    accumulator and it is printed before the if-block
     *
     * @param s Scanner connection to data input file
     */
    public static void printSum(Scanner s) {
        int accumulator = 0; // initialize accumulator
        while (s.hasNext()) { // until we reach the end-of-file
            int value = s.nextInt(); // read an int from the file
            String operation = s.next(); // read a string from the file
            System.out.printf("\n%d ",accumulator); // report current value of accumulator
            if (operation.equals(ADD)) { // in case of addition ....
                System.out.printf("%s ",PLUS); // report operation
                accumulator += value; // update accumulator
            } else if (operation.equals(SUBTRACT)) { // in case of subtraction
                System.out.printf("%s ",MINUS); // report operation
                accumulator -= value; // update accumulator
            } else if (operation.endsWith(MULTIPLY)) { // in case of multiplication
                System.out.printf("%s ",TIMES); // report operation
                accumulator *= value; // update accumulator
            } // if block
            System.out.printf("%d is %d",value, accumulator); // report operand and new accumulator
        } // while loop
    } // method printSum
} // class Exam3
