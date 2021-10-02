import java.util.Scanner;

public class MeetingOf03March2021 {

    /**
     * Given two single-digit integers numbers, print as many lines, by rotating
     * their sequence, e.g., printSquare(3,7) will result to:
     *
     * Desired     Analysis and observations
     * output:
     * ========    ===========================================
     *   34567  \                 /     34567_     <-- line 0
     *   45673   \               /      4567 3     <-- line 1
     *   56734    > Notice that: <      567 34     <-- line 2
     *   67345   /               \      67 345     <-- line 3
     *   73456  /                 \     7 3456     <-- line 4
     *                                                 ^^^^^^
     *                                                 Number of lines to print
     *                                                 can be controlled by a
     *                                                 loop that runs as many times
     *                                                 as the numbers between
     *                                                 the min and max value
     *
     * @param minNumber the first number
     * @param maxNumber the last number
     */
    public static void printSquare(int minNumber, int maxNumber) {
        int numberOfLines = maxNumber-minNumber + 1; // how many lines to print
        // loop to print that many lines
        for (int currentLine = 0; currentLine < numberOfLines; currentLine++) {
            /*
             "red" loop ... runs up to maxNumber, starting from
             minNumber + "something related to the current line"
             We determined that that "something" is the line number:

             line       min        red loop starts
             number    Number      from line number + minNumber

                0        3           3
                1        3           4
                2        3           5
                3        3           6
                4        3           7
            */
            int startRedFrom = maxNumber + currentLine;
            for (int red = startRedFrom ; red <= maxNumber ; red++ ) {
                System.out.print(red);
            }
            /*
            "yellow" loop ... run from min number to something related to
            the current line number.

            line      we want this loop to print
            number    how many and which numbers?

            0         none
            1         1 number:  minNumber
            2         2 numbers: minNumber, minNumber+1
            3         3 numbers: minNumber, minNumber+1, minNumber+2
            4         4 numbers: minNumber, minNumber+1, minNumber+2, minNumber+3
            ...       ...

            So we need a loop from minNumber to some value such that when the
            line number is 0, the loop will not execute. In other words, when
            line number is 0, the loop will start at minNumber and fulfill its
            terminating condition immediately, ie terminating value must be
            less than starting value, e.g.,
              for (int x = 3; x < 2; x++ ) {...}
            will not execute at all because 3<2 is false at the get go.

            In this case, we need a terminating condition that prevents
            the yellow loop from running when line number = 0, but allows
            it to run for subsequent lines. The expression we need is
            assigned to variable stopYellowAt below.
             */
            int stopYellowAt = minNumber - 1 + currentLine;
            for (int yellow = minNumber; yellow <= stopYellowAt ; yellow++ ) {
                System.out.print(yellow);
            }
            System.out.println(); // new line
        }
    }

    /**
     * A simple method to demonstrate if-then-else statements in an example
     * that grabs an integer number entered by the user and determines if it
     * is even or odd -- this some veeeeeery advanced stuff here :-)
     */
    public static void demonstrateIf() {
        /*
        Set up a scanner object (we call it s because we like short names)
        to "listen" to the keyboard and grab anything users enter.
         */
        Scanner s = new Scanner(System.in);

        // Prompt the use to enter something
        System.out.print("Type an integer number: ");

        // Assume that user complies and an int number is entered; call it n.
        int n = s.nextInt();

        // what's the remainder of n when divided by 2? Can be 0 or 1.
        int remainder = n % 2;

        /////////////// IF-BLOCK BEGINS HERE ///////////////
        if ( remainder == 1 ) {  // condition to check
            //^^^^^^^^^^^^^
            //  if condition is true (if remainder is one),
            //  execute following statement and exit the if-block
            System.out.println(n + " is odd.");
        } else {
            //  if condition is not true (if remainder is zero)
            // execute the following statement and exit the if-block
            System.out.println(n + " is even.");
        }
        /////////////// IF-BLOCK ENDS HERE ///////////////

        // more code outside the if-block
        System.out.println("Thank you!");
    }

    /** Driver method */
    public static void main(String[] args) {
        printSquare(2,8);
        demonstrateIf();
    }
}
