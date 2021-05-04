import java.io.File;
import java.util.Scanner;

public class SimpleArrayExamples {

    /**
     * Reads a file with double numbers (one number per line) and reports
     * its descriptive statistics, i.e., min, max, average, and count.
     */
    public static void reportStats() {
        // Establish scanner connection to file in a gentle way
        Scanner s=null;
        try {
            s = new Scanner(new File("data.txt"));

            // Initialize
            double min = (double) Integer.MAX_VALUE;
            double max = (double) Integer.MIN_VALUE;
            double sum = 0.0;
            int count = 0;
            // Read the file
            while (s.hasNext()) {
                double value = s.nextDouble();
                min = (value < min) ? value : min;
                max = (value > max) ? value : max;
                sum += value;
                count++;
            }
            System.out.printf("\n%s","*".repeat(50));
            System.out.printf("\nValues in file: %d",count);
            System.out.printf("\n           Min: %8.5f\n           Max: %8.5f\n       Average: %8.5f",min,max,sum/count);
            System.out.printf("\n\n%s","*".repeat(50));

        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }

    public static void main(String[] args) {
        reportStats();
    }

}
