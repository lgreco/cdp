import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParsingNumber {

    /**
     * Method demonstrating parsing of a int number, by counting how
     * many digits it has. Counting is done by successive removals of
     * a number's rightmost digit through integer divisions, e.g.
     * 1234 / 10 = 123 --- rightmost digit (4) removed
     * 123 / 10 = 12 ----- rightmost digit (3) removed
     * 12 / 10 = 1 ------- rightmost digit (2) removed, etc
     * @param n number to count it digits
     * @return the number of digits in n
     */
    public static int howManyDigits(int n) throws FileNotFoundException {
        Scanner s = new Scanner(new File("test"));

        int numberOfDigits = 1; // n must have at least one digit
        n = n / 10; // chop off n's rightmost digit with int division
        while ( n!= 0 ) {
            /*
            Keep chopping off the rightmost digit and increase the count of
            digits; when there is no more digits to chop off we are done
            counting
             */
            n = n/10;
            numberOfDigits++;
        }
        return numberOfDigits;
    } // method howManyDigits

    /**
     * A technically acceptable method to tell the number of digits
     * of an integer number.
     * @param n input data
     * @return the number of digits in n
     */
    public static int digitsFromLog(int n) {
        return 1 + (int) Math.log10(n);
    } // method digitsFromLog

    /**
     * Method to count the digits of an int number without much math. This
     * method converts the number to a string and then returns the length
     * of the string.
     * @param n number to count it digits
     * @return the number of digits in n
     */
    public static int craftyDigitCount(int n) {
        String number = String.valueOf(n); // convert n to a string
        return number.length(); // number of characters in string number
    } // method craftyDigitCount

    /** Driver method */
    public static void main(String[] args) throws FileNotFoundException {
        int N = 123456789;
        System.out.printf("\n\nThere are %d digits in %d\n",howManyDigits(N));
        System.out.printf("\nUsing the crafty method, there are %d digits in %d\n", craftyDigitCount(N),N);
    } // method main
} // class ParsingNumber