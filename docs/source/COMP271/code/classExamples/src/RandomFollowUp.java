import java.util.Arrays;
import java.util.Random;

/**
 * Random selection of N individuals from a group of M, based on a
 * desired fraction f, i.e., N = f*M.
 */
public class RandomFollowUp {

    public static void main(String[] args) {

        Random r = new Random();

        /**
         * Individuals are shown by first and last name initials, and the
         * last digit of their university ID number.
         */
        String[] individuals = new String[]
                {
                        "BP6", "AZ4", "TB6", "JG9",
                        "AO8", "WV9", "EK6", "GK5",
                        "SM5", "DS2", "WR1", "JR6",
                        "AR7", "AA4", "MF6", "JG4",
                        "AA2", "DS9", "VG8", "MM7"
                };

        int M = individuals.length;  // How many individuals?
        double f = 0.33;             // Fraction to select; recommend 1/3.
        int N = (int) (f*M);         // Number of people to select: what is f*M?

        /**
         * Randomly selected individuals
         */
        String[] selected = new String[N];

        /**
         * Counts how many selected so far, and also serves
         * as an index for array selected[]
         */
        int individualsSelected = 0;

        while (individualsSelected < N) {
            /**
             * Select a random integer between 0 and M-1
             */
            int atRandom = r.nextInt(M);
            /**
             * Find if the individual assigned to that position has already
             * been selected or not. It individual selected already, its
             * position would show a null value.
             */
            if (individuals[atRandom] != null) {                         // Not null, available for selection.
                selected[individualsSelected] = individuals[atRandom];   // Copy to group of selected individuals.
                individuals[atRandom] = null;                            // Set to null, to preclude duplicate selection.
                individualsSelected++;                                   // Increment count.
            }
        }

        Arrays.sort(selected); // sort alphabetically

        // print out

        System.out.println("\n\nFrom a group of " + M + " individuals, the following " + N + " have been randomly selected:\n");
        for (int i = 0; i < N; i++) {
            System.out.print("\t"+selected[i]+"  ");
            if ((i+1)%3==0) { System.out.print("\n"); }
        }
        System.out.println();
    } // method main
} // class RandomFollowUp
