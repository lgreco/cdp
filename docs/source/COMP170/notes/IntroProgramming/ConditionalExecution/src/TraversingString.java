/**
 * A simple class showcasing string traversal
 */
public class TraversingString {

    /**
     * Method to print chars of a string along with their ASCII/Unicode values
     * @param message String to parse
     */
    public static void showCharCodes(String message) {
        System.out.printf("\n\nChar\tCode");
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            System.out.printf("\n\t%s\t%3d", c, (int) c);
        }
    }

    /** Driver method */
    public static void main(String[] args) {
        showCharCodes("THIS IS A TEST");
    } // method main
}
