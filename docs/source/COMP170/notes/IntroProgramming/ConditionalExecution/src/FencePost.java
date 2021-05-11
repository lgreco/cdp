/**
 *
 */
public class FencePost {

    private static final int BASE =10;
    private static int n, r;

    public static void showDigits() {
        doTheMath();
        System.out.print( r );
        while ( n != 0 ) {
            doTheMath();
            System.out.print( " + " + r );
        }
    }

    public static void doTheMath() {
        r = n % BASE;
        n = n / BASE;
    }

    public static void main(String[] args) {
        n = 16;
        showDigits();
    }


}

