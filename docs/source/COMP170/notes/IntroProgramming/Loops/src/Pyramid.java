/**
 * A class with two methods for printing a half pyramid, aka as right angle triangle.
 * The only difference between the two methods is the counting range. Consider a
 * triangle, ok pyramid, five lines tall. Do we cound from 0 or from 1. Let's
 * see both caces
 *
 *          Desired    Counting   Counting
 *  Line    pattern    from 0     from 1
 *  ======  ========   ========   ========
 *  first    *            0          1
 *  second   **           1          2
 *  third    ***          2          3
 *  fourth   ****         3          4
 *  fifth    *****        4          5
 *
 *                        |          |
 *                        |          |-------------------------|
 *                        |          | this count matches the  |
 *                        |          | number of stars we want |
 *       |---------------------|     | to print on each line.  |
 *       | This counter needs  |     |-------------------------|
 *       | +1 added to it to   |     | see method:             |
 *       | give us the desired |     | countFromOne            |
 *       | number of stars     |     |-------------------------|
 *       |---------------------|
 *       | see method:         |
 *       | countFromZero       |
 *       |---------------------|
 */
public class Pyramid {

    /**
     * Start the line counting from 0; use +1 in the inner loop
     * to get the correct number of stars per line.
     */
    public static void countFromZero(int numberOfLines) {
        // loop to count lines
        for (int lines = 0; lines < numberOfLines; lines++) {
            // loop to count characters per line
            //                     Notice the +1 added to the
            //                     character count to give us
            //                     the desired number of stars,
            //                     beginning with 1 star when
            //                     the first line value is 0 --+
            //                                                 |
            //                                            =========
            for (int characterCount = 0; characterCount < lines + 1; characterCount++) {
                System.out.print("*");
            }
            // println for new line
            System.out.println();
        }
    }

    /**
     * Start the line counting from 1; the inner loop doesn't need an
     * adjustment to print the desired number of stars.
     */
    public static void countFromOne(int numberOfLines) {
        // loop to count lines
        for (int lines = 1; lines <= numberOfLines; lines++) {
            //        ^^^^        ^^^^
            //        Notice how this loop
            //        differs from the one in the
            //        previous method, allowing the
            //        current value of lines to determine
            //        the number of stars to print.
            //                                    |
            //                            vvvvvvvvvvvvvvvvvvvvv
            for (int characterCount = 0; characterCount < lines; characterCount++) {
                System.out.print("*");
            }
            // println for new line
            System.out.println();
        }
    }

    /** driver method */
    public static void main(String[] args) {
        countFromZero(5);
        // empty line to separate the two outputs
        System.out.println();
        countFromOne(5);
    }
}
