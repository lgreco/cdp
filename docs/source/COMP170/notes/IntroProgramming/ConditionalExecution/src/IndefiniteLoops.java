import java.util.Scanner;

/** Indefinite loops demo */
public class IndefiniteLoops {

    /**
     * Method to compute average age of students. The method keeps asking for data
     * until a negative number is entered. At that time, the method computes the
     * average value of data entered and returns it. The average age of students is
     * computed as
     *               cumulative sum of data entered   <--- int totalAge
     *    average = ---------------------------------
     *                  count of data entered         <--- int countOfEntries
     *
     * @return average Average age of students.
     */
    public static double averageAge() {
        // Set up
        Scanner s = new Scanner(System.in); // keyboard entry
        int countOfEntries = 0; // how many data entries
        int totalAge = 0; // cumulative sum
        int currentEntry = 0; // current data entered
        boolean acceptableData = true; // loop condition, set to true to ensure loop runs at least once

        while ( acceptableData ) {
            // Read data
            System.out.printf("\nEnter student's age: ");
            currentEntry = s.nextInt();

            // determine if the loop can continue by telling if the current data entered
            // is negative or not.
            acceptableData = (currentEntry >=0 ); // acceptable data entries must be non-negative values

            // If data acceptable, update sum and counter
            if ( acceptableData ) {
                totalAge = totalAge + currentEntry; // add this student's age to the cumulative sum
                countOfEntries++; // increment the student count
            }
        }
        // After loop ends, compute average and return
        double average = ( (double) totalAge / (double) countOfEntries );
        return average;
    } // method averageAge

    /**
     * Method shows how the for-loop and the while-loop can perform the same tasks.
     */
    public static void showForAndWhileEquivalency() {

        int N = 10; // how many times to execute a loop

        // Use a for-loop to print the first N numbers.
        System.out.print("  For-loop output: ");
        for (int i = 0; i < N; i++) {
            System.out.printf("%4d",i);
        }
        System.out.println();

        // Use a while-loop to print the first N numbers.
        System.out.print("While-loop output: ");
        boolean carryOn = true; // Loop condition, set to true, ensures at least one round
        int i = 0; // loop counter
        while (carryOn) {
            System.out.printf("%4d",i);
            i++; // increment loop counter ... needs to be before reevaluating loop condition. WHY?
            carryOn = ( i < N ); // reevaluate loop condition
        }
        System.out.println();
    }

    /** Driver method */
    public static void main(String[] args) {
        // System.out.println(averageAge());
        showForAndWhileEquivalency();
    }
}
