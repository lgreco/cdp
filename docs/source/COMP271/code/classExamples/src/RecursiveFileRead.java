import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecursiveFileRead {

    public static void reverse(Scanner input) {
        if (input.hasNextLine()) {
            String line = input.nextLine();
            reverse(input);
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        File file = new File("/Users/lirakliotis-old/cdp/source/COMP271/code/classExamples/out/production/classExamples/text.txt");
        s = new Scanner(file);
        reverse(s);
    }
}
