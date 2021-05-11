import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ComplexNumber implements Comparable<ComplexNumber> {
    /*                     |          |          |
                           |          |          |
                           |          |          +-- class of objects where the
                           |          |              methods in this interface
                           |          |              will be applied to.
                           |          |
                           |          +------------- name of interface we are
                           |                         committed to implement.
                           |
                           +------------------------ our commitment that this class
                                                     will provide the functionality
                                                     specified in the inteface(s)
                                                     named here.
     */

    /**
     * A complex number c is represented as a pair of two double values:
     *    (real, imaginary)
     *  such that c = real + imaginary * i
     *  where i is the basis of imaginary numbers (i*i = -1)
     */
    private double real;
    private double imaginary;

    public ComplexNumber() {
        real = 1.0;
        imaginary = 1.0;
    } // default constructor creates 1+1i

    public ComplexNumber(double a, double b) {
        real = a;
        imaginary = b;
    } // full constructor creates a+bi

    /**
     * Returns the magnitude of c = a+bi as |c| = sqrt(a*a+b*b)
     * @param c input number
     * @return magnitude |c|
     */
    public double magnitude(ComplexNumber c) {
        return Math.sqrt(c.real*c.real+c.imaginary*c.imaginary);
    } // method magnitude

    /**
     * Implementation of Comparable using magnitude() as basis for natural order
     * @param c number to compare to
     * @return -1,0,1
     */
    public int compareTo(ComplexNumber c) {
        double left = magnitude(this); // object to the left of compareTo method
        double right = magnitude(c);      // object to the right of compareTo method
        int comparison = 0;
        if (left < right)
            comparison = -1;
        if (left > right)
            comparison = +1;
        return comparison;
    }  // method compareTo

    /**
     * @return String representation of complex number as (re,im) with
     * 3 decimal digits only.
     */
    public String toString() {
        return String.format("(%.3f, %.3f)",real, imaginary);
    } // method toString

    /**
     * @return String representation of complex number as z=(re,im) followed
     * by magnitude |z|, each number formatted to 3 decimal digits.
     */
    public String toStringWithMagnitude() {
        return String.format("z = (%.3f, %.3f), |z|=%.3f",real, imaginary, magnitude(this));
    } // method toStringWithMagnitude

    /* Let's see if we can create an ArrayList of complex numbers
       and use the JFC's sort() to re-order it using the natural
       order we establish with the implementation of the
       Comparable interface.
    */
    public static void main(String[] args) {

        ArrayList<ComplexNumber> inumbers = new ArrayList<ComplexNumber>();

        // let's populate the ArrayList with 10 random complex numbers
        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            inumbers.add(new ComplexNumber(r.nextDouble(), r.nextDouble()));
        }


        System.out.println("\nBefore sorting");
        for (ComplexNumber c: inumbers) {
            System.out.println(c.toStringWithMagnitude());
        }

        // Collections' sort() works because the class has
        // implemented the Comparable interface.
        Collections.sort(inumbers);

        System.out.println("\nAfter sorting");
        for (ComplexNumber c: inumbers) {
            System.out.println(c.toStringWithMagnitude());
        }
    }
}