import java.util.Scanner;

public class ExamineInput1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("token?");
        System.out.println("\thasNextInt = " + console.hasNextInt());
        System.out.println("\thasNextDouble = " + console.hasNextDouble());
        System.out.println("\thasNext = " + console.hasNext());
    }
}
