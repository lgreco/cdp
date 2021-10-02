import java.util.Random;

public class EvaluateDisArray {
    public static void main(String[] args) {
        // instatiate object from student's DisArray class
        DisArray_original_plain demo = new DisArray_original_plain();
        // set up a random generator to create random lengths of
        // test inputs, up to 101 elements, and create the test arrays
        Random r = new Random();
        int testDimension = 1 + r.nextInt(100);
        int[] testInt = new int[testDimension];
        String[] testString = new String[testDimension];
        // Call the student's convert2D methods (through the demo instance)
        // and populate the 2D output arrays.
        int[][] testIntOutput = demo.convert2D(testInt);
        String[][] testStringOutput = demo.convert2D(testString);
        // obtain measurements
        int rowsI = testIntOutput.length;       // rows in int ouput
        int colsI = testIntOutput[0].length;    // columns in int output
        int rowsS = testStringOutput.length;    // rows in String output
        int colsS = testStringOutput[0].length; // columns in String output
        int sizeI = rowsI*colsI; // total elements in int output
        int sizeS = rowsS*colsS; // total elements in String output
        int sqr = (int) Math.sqrt((double) testDimension);
        int squar = (int) Math.ceil(Math.sqrt((double) testDimension));
        int paddI = sizeI-testDimension; // how many elements were padded in int
        int paddS = sizeS-testDimension; // how many elements were padded in String
        int worsI = squar*squar - testDimension; // worst case padding for int
        int worsS = squar*squar - testDimension ; // worst case padding for String
        // report results
        System.out.println("Evaluating DisArray class for: " + demo.student);
        System.out.println("\tTest dimension = "+testDimension);
        System.out.println("\tint(SQRT("+testDimension+")) = "+sqr);
        System.out.println("\tceil(SQRT("+testDimension+")) = "+squar);
        System.out.println("\t2D size for integer array is "+rowsI+"x"+colsI);
        System.out.println("\t2D size for String array is "+rowsS+"x"+colsS);
        System.out.println("\tPadded elements in integer: " + paddI +
                " (worst case scenario "+worsI+")");
        System.out.println("\tPadded elements in String: " + paddS +
                " (worst case scenario "+worsS+")");
    }
}