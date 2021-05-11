public class ReCurse {

    /**
     * Computes n!, recursively, with n >= 0
     * @param n
     * @return n!
     */
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("What's wrong with you? Use a non negative number next time!");
        } else {
            if ( n == 0) {
                return 1;
            } else {
                return n*factorial(n-1);
            }
        }
    }

    /**
     * Computes recursively x^y, for y >=0
     * @param x
     * @param y
     * @return x^y
     */
    public static int pow(int x, int y) {
        if (y < 0) {
            throw new IllegalArgumentException("y is negative!");
        } else {
            if (y==0) {
                return 1;
            } else {
                return x * pow(x,y-1);
            }
        }
    }

    public static void main(String[] args) {
        int x = factorial(5);
        System.out.println(x);
        System.out.println();
        System.out.println(pow(3,5));
    }
}
