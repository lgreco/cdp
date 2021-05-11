/**
 * Class with methods that "draw" a spinning top based on user
 * specified segment height. The "drawing" has 7 segments like so:
 *
 *    ||       \
 *    ||        \ First segment of height N = 4 and stick of width 2
 *    ||        / with bars at positions N and N+1
 *    ||       /
 *    ||       \
 *   *||*       \ Second segment of height N = 4
 *  **||**      / and notice the "bulbous" shape developing
 * ***||***    /
 * ========    } Third segment, single line height but width 2N
 * ***||***    \
 *  **||**      \  Fourth segment of height N =4 and stick of width 2,
 *   *||*       /  with bars at positions N and N+1
 *    ||       /
 *    ||       \
 *    ||        \ Fifth segment of height N = 4
 *    ||        / (same as the first segment)
 *    ||       /
 *    ||       \
 *    ||        \ Another instance of the fifth segment
 *    ||        /
 *    ||       /
 * ========    \
 * ========     \ Last segment of height N = 4 and each
 * ========     / line comprising 2N characters
 * ========    /
 *
 */
public class SpinningTop {

    /**
     * The following class variables allow us to
     * change the symbols we use to print the spinning top
     * from a single location, instead of replacing them
     * multiple times across several methods.
     */
    private static final String SPACE = " ";
    private static final String ROD = "||";
    private static final String STAR = "*";
    private static final String MIDDLE = "=";

    /**
     * Method to print the rod segment of the spinning top.
     *
     * @param N number of lines to print
     */
    public static void rod(int N) {
        // loop to print lines
        for (int i = 0; i < N; i++) {
            // loop to repeat spaces
            for (int j = 0; j < N - 1; j++) {
                // print a single space (as many times as the j loop dictates
                System.out.print(SPACE);
            }
            // after printing the spaces, print the vertical bars
            System.out.println(ROD); // println to move to next line
        }
    }

    /**
     *
     * Method to print the first part of the spinner.
     *
     *    Desired    Line     Number of   Number of    Number of
     *    Pattern    number   spaces      stars        starts
     *    for N=4                         before       after rod
     *    lines                           rod          rod
     *
     *      ||       0          3           0            0
     *     *||*      1          2           1            1
     *    **||**     2          1           2            2
     *   ***||***    3          0           3            3
     *
     *               ^          ^           ^            ^
     *               i        (N-1)-i       i            i
     *
     * @param N number of lines to print
     */
    public static void topHalfSegment(int N) {
        // loop to print lines
        for (int i = 0; i < N; i++) {
            // Each line has a different number of spaces and stars
            int numberOfSpaces = (N-1)-i;
            int numberOfStars = i;

            // loop to print spaces
            for (int j = 0; j < numberOfSpaces; j++) {
                System.out.print(SPACE);
            }

            // loop to print stars
            for (int j = 0; j < numberOfStars; j++) {
                System.out.print(STAR);
            }

            // print the rod part of the spin
            System.out.print(ROD);

            // another loop to print starts after the rod
            for (int j = 0; j < numberOfStars; j++) {
                System.out.print(STAR);
            }

            System.out.println(); // println for new line
        }
    }

    public static void middleSegment(int N) {

        // prints one line with 2N middle element
        for (int i = 0; i < 2*N; i++) {
            System.out.print(MIDDLE);
        }
        System.out.println(); // println to move to the next line
    }

    /**
     *
     *  Method to print the second half of the spinner.
     *
     *  Desired    Line     Number of   Number of    Number of
     *  pattern    number   spaces      stars        starts
     *  for N=4                         before       after rod
     *  lines                           rod          rod
     *
     *  ***||***      0        0          3           3
     *   **||**       1        1          2           2
     *    *||*        2        2          1           1
     *     ||         3        3          0           0
     *
     *                ^        ^          ^           ^
     *
     *                i        i       (N-1)-i     (N-1)-i
     *
     * @param N number of lines to print
     */
    public static void bottomHalfSegment(int N) {

        // loop to print lines
        for (int i = 0; i <N; i++) {

            // print the spaces first, starting with 0 spaces, and adding 1 per line
            for (int j = 0; j < i; j++) {
                System.out.print(SPACE);
            }

            // print stars first; start with N-1 stars and subtract a star from every line
            for (int j = (N-1)-i; j > 0  ; j--) {
                System.out.print(STAR);
            }

            // print the rod at the center
            System.out.print(ROD);

            // print the stars to the right of the stick
            for (int j = N-1-i; j > 0  ; j--) {
                System.out.print(STAR);
            }

            System.out.println(); // println for new line
        }
    }

    /**
     * Method to print the bottom segment of the spin
     * @param N lines to print
     */
    public static void bottomSegment(int N) {

        // print N lines
        for (int i = 0; i < N; i++) {

            // print 2N MIDDLE elements
            for (int j = 0; j < 2 * N; j++) {
                System.out.print(MIDDLE);
            }

            System.out.println(); // println to move to the next line.
        }
    }

    /** Driver method */
    public static void main(String[] args) {
        int N = 4;
        rod(N);
        topHalfSegment(N);
        middleSegment(N);
        bottomHalfSegment(N);
        rod(N);
        rod(N);
        bottomSegment(N);
    }
}
