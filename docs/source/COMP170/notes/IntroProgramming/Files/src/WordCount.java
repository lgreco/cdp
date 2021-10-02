import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Write a program WordCount.java that counts the number of words, lines,
 * and total characters (not including whitespace) in a paper, assuming
 * that consecutive words are separated either by spaces or end-of-line
 * characters.
 */
public class WordCount {

    public static final char SPACE = ' ';

    /**
     * Method uses one scanner and one for-loop and throws an i/o exception if
     * the file is missing. The scanner reads the file line-by-line and the loop
     * parses each line counting its spaces and computing:
     * words in line = spaces + 1
     *
     * @param file File to count
     * @throws IOException if file not available
     */
    public static void countTextWith1Scanner(File file) throws IOException {
        Scanner text = new Scanner(file); // setup scanner
        int lineCount = 0, wordCount = 0, characterCount = 0; // init counters
        while (text.hasNext()) { // read file line-by-line
            lineCount++; // increment line count
            String line = text.nextLine(); // capture line as string
            int numberOfSpaces = 0; // assume it's empty line (no words, ie no spaces)
            for (int i = 0; i < line.length(); i++) { // parse line character by character
                if (line.charAt(i) == SPACE) { // if character is a space
                    numberOfSpaces++; // increment space counter
                }
            }
            if (numberOfSpaces > 0) { // if 1 or more spaces, line has words, words have chars
                wordCount += numberOfSpaces + 1; // how many words
                characterCount += line.length() - numberOfSpaces; // exclude spaces from char count
            }
        }
        System.out.printf("\n\nFile %s has\n\t%8d lines\n\t%8d words, and\n\t%8d characters\n(counting accomplished with 1 scanner and 1 for-loop)\n\n",
                file.getName(), lineCount, wordCount, characterCount);
    } // method countTextWith1Scanner

    /**
     * Method users two scanners to count, and tries to catch an exception without crashing
     * the program. One scanner reads the file line-by-line, the second scanner tokenizes each
     * line to words.
     *
     * @param file
     */
    public static void countTextWith2Scanners(File file) {
        Scanner text = null; // declare scanner object within method scope
        int lineCount = 0, wordCount = 0, characterCount = 0; // init counters
        try { // try this first
            text = new Scanner(file); // assign file to scanner
        } catch (Exception e) { // but if it doesn't work, don't crash my program
            System.out.printf("\nFile %s not available. Is it in the proper working directory?\n", file.getName());
        }
        if (text != null) { // if all went well and the file is now attached to the scanner
            while (text.hasNext()) { // read file line-by-line
                lineCount++; // increment line count
                String line = text.nextLine(); // capture line as string
                Scanner lineFromFile = new Scanner(line); // turn captured line to Scanner
                while (lineFromFile.hasNext()) { // scan captured line
                    String word = lineFromFile.next(); // word by word
                    wordCount++; // increment word count
                    characterCount += word.length(); // add word length to char count
                }
            }
            System.out.printf("\n\nFile %s has\n\t%8d lines\n\t%8d words, and\n\t%8d characters\n(counting accomplished with 2 scanners)\n\n",
                    file.getName(), lineCount, wordCount, characterCount);
        }
    }// method countTextWith2Scanners

    /**
     * Driver method
     */
    public static void main(String[] args) throws IOException {
        File hamlet = new File("hamlet.txt");
        countTextWith1Scanner(hamlet);
        countTextWith2Scanners(hamlet);
    }
}
