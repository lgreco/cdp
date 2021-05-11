import javax.swing.*;
import java.util.Random;

public class WhileDemo {

    /**
     * Simple implementation of Newton's solution for
     * finding the sqrt of a number, using the approximation
     *
     *    x    = 0.5 * (x  + a/x )
     *     n+1           n      n
     *
     * @param a number whose square root we compute
     * @param precision convergence
     * @return sqrt of a
     */
    public static double newtonSQRT(double a, double precision) {
        final int STOP_AFTER = 1000000;
        double xcurrent, xnext; // x_n+1 and x_n ... we only need two
        xcurrent = a; // a lucky guess
        boolean notDoneYet = true; // test condition to continue loop
        int steps = 0; // step counter as a fail safe mechanism if loop doesnt converge
        while ( notDoneYet ) { // when notDoneYet is true loop continues
            xnext = 0.5 * ( xcurrent + a/xcurrent ); // compute next step from current value
            double margin = Math.abs(xcurrent-xnext); // compute the difference between current and next
            /* Update the test condition
            The condition turns false if the margin drops below the required precision or
            if the number of steps exceed STOP_AFTER. This second condition in a fail-safe
            mechanism in case the sequence does not converge.
             */
            notDoneYet = ( margin > precision ) && ( steps < STOP_AFTER );
            xcurrent = xnext; // get ready for the next iteration
            steps++; // increment step counter
        }
        return  xcurrent;
    } // method newtonSQRT

    /**
     *
     * @param precision
     * @return
     */
    public static double pi(double radius, double precision) {
        final int STOP_AFTER = 100000000;
        Random rng = new Random();
        double pi = 4.0;
        double edge = 2.0 * radius;
        boolean notDoneYet = true;
        double withinCircle = 1.;
        double withinSquare = 2.;
        while ( notDoneYet ) {
            double x = -radius + edge*rng.nextDouble();
            double y = -radius + edge*rng.nextDouble();
            double d = Math.sqrt(x*x+y*y);
            withinSquare++;
            if ( d <= radius ) { withinCircle++; }
            double currentPi = 4.0 * ( withinCircle ) / ( withinSquare);
            double margin = Math.abs(currentPi-pi);
            notDoneYet = (margin > precision) && (withinSquare < STOP_AFTER);
            pi = currentPi;
        }
        return pi;
    }

    /** Driver method */
    public static void main(String[] args) {
        double a = 10;
        System.out.println(newtonSQRT(a,0.000000000000001));
        System.out.println(Math.sqrt(a));
        System.out.println( );
        System.out.println(Math.PI);
        System.out.println(pi(1.0, 0.0000000001));
        System.out.println();
    }
}
