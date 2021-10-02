
/**
 * A class to expand a linear array with inputLength elements to a rectilinear
 * one of size nxm such that inputLength <= n*m. A testing method has been
 * provided (class EvaluateDisArray) that requires a String with the name
 * of the student who wrote the code, because this was assigned as homework
 * in LI's LUC.COMP271.SU20 course.
 */

public class DisArray {

    public String student = "Leo Irakliotis"; // who wrote this class?

    /**
     * Method to convert an int linear array to a rectilinear one of same type.
     * @param a linear array
     * @return a rectilinear array with input elements in row-major order.
     */
    public int[][] convert2D(int[] a) {

        int n, m;        /* size of output, rectilinear array  */
        int inputLength; /* size of input, linear array        */
        int i, j;        /* int indices for various for-loops  */

        inputLength = a.length; // size of input array

        // Compute dimensions using local (private) method NM that assigns
        // number of rows (n) to the integer value of the square root of
        // the input array length; and number of columns (m) to the nearest
        // integer so that m*n = inputLength or minimally > than.
        int size[] = NM(inputLength);
        n = size[0];
        m = size[1];

        // setup output array
        int[][] r = new int[n][m];

        // populate output array in row-major order, padding with 0s when necessary
        for (i=0; i<n; i++) {
            for (j=0; j<m; j++) {
                if (i*n+j < inputLength) // int arrays are initializes to 0s, so we
                    r[i][j] = a[i*n+j] ;  // change the values of necessary elements
            }
        }
        return r;
    }

    /**
     * Method to convert a String linear array to a rectilinear one of same type.
     * @param a linear array
     * @return a rectilinear array with input elements in row-major order.
     */
    public String[][] convert2D(String[] a) {

        int n, m;        /* size of output, rectilinear array  */
        int inputLength; /* size of input, linear array        */
        int i, j;        /* int indices for various for-loops  */

        inputLength = a.length; // size of input array

        // Compute dimensions using local (private) method NM that assigns
        // number of rows (n) to the integer value of the square root of
        // the input array length; and number of columns (m) to the nearest
        // integer so that m*n = inputLength or minimally > than.
        int size[] = NM(inputLength);
        n = size[0];
        m = size[1];

        // setup output array
        String[][] r = new String[n][m];

        // populate output array in row-major order, padding with nulls when necessary
        for (i=0; i<n; i++) {
            for (j = 0; j < m; j++) {
                if (i*n+j < inputLength)  // String arrays are initializes to nulls, so we
                    r[i][j] = a[i*n+j];   // change the values of necessary elements
            }
        }
        return r;
    }

    /**
     * Method to convert linear size to square-ish dimensions for 2D array
     * @param len length of linear array
     * @return array with two values: [0]: number of rows; [1] number of columns
     */
    private int[] NM (int len) {
        int nm[] = new int[2];
        nm[0] = (int) Math.floor(Math.sqrt((double) len));
        nm[1] = (int) Math.ceil(((double) len) / ((double) nm[0]));
        return nm;
    }

    /**
     * Local main method to test the code
     * @param args
     */
    public static void main(String[] args) {

    }
}
