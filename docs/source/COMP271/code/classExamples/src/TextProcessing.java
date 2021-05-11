import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TextProcessing {
    public static void main(String[] args) throws FileNotFoundException {

        Set<String> wordsSet = new HashSet<>();

        Scanner f = new Scanner(new File("/Users/lirakliotis-old/cdp/source/COMP271/code/classExamples/src/highwayman.txt"));
        int counter = 0;
        while (f.hasNext()) {
            String word = f.next();
            counter++;
            word = word.toLowerCase();
            wordsSet.add(word);
        }
        System.out.println("The Highwayman has "+ counter + " words!");
        System.out.println("There are " + wordsSet.size() + " unique words.");
        System.out.println();
        System.out.println(wordsSet);
    }
}
