/**
 * A naive program illustrating integer division and
 * integer remainder to determine the seat of a person
 * standing in line to enter a theater.
 */
public class NaiveLinearTo2D {

    public static void main(String[] args) {
        // The following two variables can be changed by the user
        int seatsPerRow = 4;
        int yourPositionInLine = 14;

        // In response to the values above, the following two
        // variables are calculated.
        int yourRow = yourPositionInLine / seatsPerRow;
        int yourColumn = yourPositionInLine % seatsPerRow;

        // The printf command allows us to mix text and data in the printout.
        // Notice that the command is broken in multiple lines, making the code more readable.
        System.out.printf("\n\nGiven %d seats per row and %d people ahead of you," +
                "\nyour seat assignment is row: %d, column: %d.\n\n",
                seatsPerRow, yourPositionInLine, yourRow, yourColumn);
    }
}
