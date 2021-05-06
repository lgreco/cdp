import java.io.File;
import java.util.Scanner;

public class Exam3 {

    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";

    public static void main(String[] args) {
        Scanner s = null;
        File numbersFile = new File("numbers.txt");
        try {
            s = new Scanner(numbersFile);
        } catch (Exception e) {
            System.out.println("File not found.");
        }
        printSum(s);
    }

    public static void printSum(Scanner s) {
        int sum = 0;
        while (s.hasNext()) {
            int value = s.nextInt();
            String operation = s.next();
            System.out.printf("\n%d ",sum);
            if (operation.equals(ADD)) {
                System.out.printf("plus %d is ",value);
                sum += value;
            } else if (operation.equals(SUBTRACT)) {
                System.out.printf("minus %d is ",value);
                sum -= value;
            } else if (operation.endsWith(MULTIPLY)) {
                System.out.printf("times %d is ",value);
                sum *= value;
            }
            System.out.printf("%d",sum);
        }
    }
}
