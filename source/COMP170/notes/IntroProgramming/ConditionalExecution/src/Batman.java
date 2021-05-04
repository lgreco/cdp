/**
 * The class offers different methods as solutions to the Holy Digits problem.
 * Each solution is progressively more efficient, beginning with plain brute force
 * approach, for illustrative purposes. The problem asks to guess the street
 * number where a villain may hit on Pennsylvania Av, by providing the following
 * clues/requirements:
 * - it must be a four-digit number;
 * - it must be an odd number;
 * - the sum of its digits is 27;
 * - the first (from left) digit is three times the third digit.
 * The answer to the problem is 9837.
 * <p>
 * Most methods in this class use positional variables, as follows:
 * <p>
 * 9   8   3   7
 * ^   ^   ^   ^
 * |   |   |   |
 * +------------+   |   |   +-------+
 * |                |   |           |
 * |            +---+   +--+        |
 * |            |          |        |
 * int          int        int      int
 * k            h          d        u
 * (kilo)       (hecto)    (deca)   (units)
 * thousands    hundreds   tens     units
 * <p>
 * with variables: k, h, d, and u representing single-digit
 * values. Any number 0-9999 can be assembled using the positional variables:
 * <p>
 * k * 1000 + h * 100 + d * 10 + u * 1
 *
 * The class includes a method, printResults, that is called from the various
 * methods to report the answer, the number of steps it took it to get to that
 * answer, and the technique used.
 *
 */

public class Batman {

  /* These are variables used in most of the methods below, so I am saving myself
  some typing by declaring them here, eliminating the need to do so in each loop
  or in each scope they are used.
   */
  private static int counter; // Tracks and reports number of steps in a method
  private static int desiredSum = 27; // the required sum for all digits
  /*
  Positional variables and naming convention
  k - kilo ( digit for 1000s )
  h - hecto ( digit for 100s )
  d - deca ( digit for 10s )
  u - unit ( digit for 1s )
  Representation:
    dcku = d * 1000 + c * 100 + d * 10 + u * 1
   */
  private static int u, d, h, k;

  /**
   * Brute force method using one loop (hence the 1L designation). The method
   * checks every number from 0 to 9999, decomposing it to its four positional
   * digits, and testing for each requirement.
   */
  public static void useBruteForce1L() {
    counter = 0; // Reset counter
    for (int number = 0; number < 10000; number++) { // Loop over all numbers 0-9999
      int n = number; // Local variable to manipulate without affecting loop variable
      u = n % 10; // Extract rightmost digit
      n = n / 10; // Get rid of rightmost digit
      d = n % 10; // Extract rightmost digit
      n = n / 10; // Get rid of rightmost digit
      h = n % 10; // Extract rightmost digit
      n = n / 10; // Get rid of rightmost digit
      k = n % 10; // Extract rightmost digit
      if ((k != h && h != d && d != u && k != u && h != u)
          && (k == 3 * d)
          && (number % 2 == 1)
          && (k + h + d + u == 27)) {
        printResult(counter, k, h, d, u, "brute force with one loop");
      }
    }
  } // method useBruteForce1L

  /**
   * Brute force method with 4 for-loops (hence the designation 4L). Each for-loop
   * produces digits 0-9 for the corresponding positional variable, resulting to
   * all possible number combinations from 0000 to 9999. The use of for-loops for
   * each positional variable eliminates the need for decomposing a number to its
   * constituent digits using modulo arithmetic. The method also introduces four
   * boolean variables, corresponding to requirements we wish to test the resultant
   * number for.
   */
  public static void useBruteForce4L() {
    counter = 0; // Reset counter
    for (k = 0; k < 10; k++) { // digit for 10^3
      for (h = 0; h < 10; h++) { // digit for 10^2
        for (d = 0; d < 10; d++) { // digit for 10^1
          for (u = 0; u < 10; u++) { // digit for 10^0
            /*
            The following four boolean variables check for the conditions we need
             differentDigits: all digits are different
                      thrice: the thousands digits is 3X the tens digits
                         odd: the number is odd
                      addsUp: the digits add up to the desired sum
             */
            boolean differentDigits = k != h && h != d && d != u && k != u && h != u;
            boolean thrice = k == 3 * d;
            boolean odd = u % 2 == 1;
            boolean addsUp = (k + h + d + u) == desiredSum;
            if (differentDigits && thrice && odd && addsUp) { // apply all tests together
              printResult(counter, k, h, d, u, "brute force with 4 loops");
            }
            counter++;
          }
        }
      }
    }
  } // method useBruteForce4L

  /**
   * The method is a variation of useBruteForce4L. In this method, the for-loop
   * for the thousands begins from 1 instead of 0, realizing that we are looking
   * for 4-digit numbers, therefore there is no reason testing numbers 000-999.
   */
  public static void useBrutishForce() {
    counter = 0; // Reset counter
    for (k = 1; k < 10; k++) {
      for (h = 0; h < 10; h++) {
        for (d = 0; d < 10; d++) {
          for (u = 0; u < 10; u++) {
            boolean differentDigits = k != h && h != d && d != u && k != u && h != u;
            boolean thrice = k == 3 * d;
            boolean odd = u % 2 == 1;
            boolean addsUp = (k + h + d + u) == desiredSum;
            if (differentDigits && thrice && odd && addsUp) {
              printResult(counter, k, h, d, u, "brute-ish force");
            }
            counter++;
          }
        }
      }
    }
  } // method useBrutishForce

  /**
   * This method reduces the range of the units loop to 1, 3, 5, 7, and 9 thus
   * producing only odd numbers.
   */
  public static void useOnlyOddUnits() {
    counter = 0; // Reset counter
    for (k = 1; k < 10; k++) {
      for (h = 0; h < 10; h++) {
        for (d = 0; d < 10; d++) {
          for (u = 1; u < 10; u += 2) {
            boolean differentDigits = k != h && h != d && d != u && k != u && h != u;
            boolean thrice = k == 3 * d;
            boolean addsUp = (k + h + d + u) == desiredSum;
            if (differentDigits && thrice && addsUp) {
              printResult(counter, k, h, d, u, "odd units only");
            }
            counter++;
          }
        }
      }
    }
  } // method useOnlyOddUnits

  /**
   * The method reduces the range of the loops for thousands and tens because we
   * are interested only in numbers where thousands = 3 * tens. Therefore the
   * thousands loop steps through 3, 6, and 9, and the tens loop through 1,2, and 3.
   */
  public static void focusOn3000s() {
    counter = 0; // Reset counter
    for (k = 3; k < 10; k += 3) {
      for (h = 0; h < 10; h++) {
        for (d = 1; d < 4; d++) {
          for (u = 1; u < 10; u += 2) {
            boolean differentDigits = k != h && h != d && d != u && k != u && h != u;
            // NO LONGER NEED THIS: boolean thrice = thousands == 3*tens;
            // NO LONGER NEED THIS: boolean odd = units % 2 == 1;
            boolean addsUp = (k + h + d + u) == desiredSum;
            if (differentDigits && addsUp) {
              printResult(counter, k, h, d, u, "narrower loops for thousands, tens");
            }
            counter++;
          }
        }
      }
    }
  } // method focusOn3000s

  /**
   * This method eliminates the loop for thousands, computing that digit directly
   * from the value of the tens digit, using the restriction
   *   thousands = 3 * tens
   */
  public static void compute1000s() {
    counter = 0; // Reset counter
    for (u = 1; u < 10; u += 2) {
      for (d = 1; d < 4; d++) {
        for (h = 0; h < 10; h++) {
          k = 3 * d; // Obtain thousands directly from tens
          boolean differentDigits = k != h && h != d && d != u && k != u && h != u;
          boolean addsUp = (k + h + d + u) == desiredSum;
          if (differentDigits && addsUp) {
            printResult(counter, k, h, d, u, "the 3X dependency");
          }
          counter++;
        }
      }
    }
  } // method compute1000s

  /**
   * This method eliminates the loop for hundreds because it can be computed
   * directly from the requirement that
   *   thousands + hundreds + tens + units = desiredSum ( = 27 )
   *               ^^^^^^^^
   *               the only unknown
   */
  public static void subtractFrom27() {
    counter = 1; // Reset counter
    for (u = 1; u < 10; u += 2) {
      for (d = 1; d < 4; d++) {
        k = 3 * d;
        h = desiredSum - u - d - k; // hundreds is the only unknown
        boolean singleDigit = h < 10;
        boolean differentDigits = k != h && h != d && d != u && k != u && h != u;
        System.out.printf("%d %d %d %d\n", k, h, d, u);
        if (singleDigit && differentDigits) {
          printResult(counter, k, h, d, u, "27 to guess hundreds");
          break;
        }
        counter++;
      }
    }
  } // method subtractFrom27

  public static void alternateTens() {
    counter = 0; // Reset counter
    for (u = 1; u < 10; u += 2) {
      d = 1;
      boolean diffTensUnits = d != u;
      boolean tensLess4 = d < 4;
      while (diffTensUnits && tensLess4) {
        k = 3 * d;
        h = desiredSum - u - d - k;
        boolean singleDigit = h < 10;
        boolean differentDigits = k != h && h != d && k != u && h != u;
        if (differentDigits && singleDigit) {
          printResult(counter, k, h, d, u, "one while loop and one for loop");
        }
        counter++;
        d++;
        diffTensUnits = d != u;
        tensLess4 = d < 4;
      }
    }
  } // method alternateTens

  public static void asGoodAsItGets() {
    counter = 0; // Reset counter
    u = 5;
    boolean continueUnitLoop = true;
    while (continueUnitLoop) {
      d = 3;
      boolean continueTensLoop = desiredSum - 3 * d - d - u < 19;
      while (continueTensLoop) {
        d--;
        continueTensLoop = desiredSum - 3 * d - d - u < 19;
        counter++;
      }
      k = 3 * d;
      u += 2;
      continueUnitLoop = desiredSum - k - d - u > 19;
    }
    k = 3 * (1 + d);
    h = desiredSum - k - d - u;
    printResult(counter, k, h, d, u, "while loops only");
  }

  public static void printResult(int c, int tho, int hun, int ten, int uni, String technique) {
    System.out.printf("\nAfter %d tests, I found the address number %d %d %d %d using %s.\n", c, tho, hun, ten, uni, technique);
  }

  public static void main(String[] args) {
    useBruteForce1L();
    useBruteForce4L();
    useBrutishForce();
    useOnlyOddUnits();
    focusOn3000s();
    compute1000s();
    subtractFrom27();
    alternateTens();
    System.out.println();
    asGoodAsItGets();
  }


}
