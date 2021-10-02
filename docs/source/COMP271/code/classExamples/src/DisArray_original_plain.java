/**
 * A class to expand a linear array of size len to a rectilinear one
 * of size nxm such that len < n*m, with the provision that
 * n=m=ceiling(sqrt(len)) otherwise.
 */
public class DisArray_original_plain {

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

        // Compute dimensions
        n = (int) Math.floor(Math.sqrt((double) inputLength));
        m = (int) Math.ceil(((double) inputLength) / ((double) n));

        // setup output array
        int[][] r = new int[n][m];

        // populate output array in row-major order, padding with 0s when necessary
        for (i=0; i<n; i++) {
            for (j=0; j<m; j++) {
                if (i*n+j < inputLength) // int arrays are initializes to 0s, so we
                    r[i][j] = a[i*n+j];  // change the values of necessary elements
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

        // Compute dimensions
        n = (int) Math.floor(Math.sqrt((double) inputLength));
        m = (int) Math.ceil(((double) inputLength) / ((double) n));

        // setup output array
        String[][] r = new String[n][m];

        // populate output array in row-major order, padding with nulls when necessary
        for (i=0; i<n; i++) {
            for (j = 0; j < m; j++) {
                if (i * n + j < inputLength)  // String arrays are initializes to nulls, so we
                    r[i][j] = a[i * n + j];   // change the values of necessary elements
            }
        }
        return r;
    }
}