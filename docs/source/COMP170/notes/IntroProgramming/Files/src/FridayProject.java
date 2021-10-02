import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Create a class that select a random question from a file of multiples questions.
 * The selection works like this: first we cound how many questions are there in the file,
 * assuming one question per line.
 * Then we get a random number 1 - numberquestions
 * Then we go back to the file, skip the first numberofquestions-1 lines and read the
 * next line, and that's our question.
 */
public class FridayProject {

  /**
   * Counts the lines in a file
   * @param fileName file whose contents we want to count
   * @return the number of lines in the file
   * @throws FileNotFoundException
   */
  public static int countTheLines(String fileName) throws FileNotFoundException {
    Scanner file = new Scanner(new File(fileName));
    int lineCount = 0;
    while ( file.hasNext() ) {
      lineCount++;
      file.nextLine();
    }
    return lineCount;
  } // method countTheLines

  public static String selectQuestionAtRandom(String fileName) throws FileNotFoundException {
    String randomQuestion = "NO QUESTION FOUND";
    // "rewind" the file
    Scanner rewoundFile = new Scanner(new File(fileName));
    int numberOfLines = countTheLines(fileName);
    // get random number between 1 and numberOfLines
    Random rng = new Random();
    int randomLineNumber = rng.nextInt(numberOfLines)+1;
    int lineCounter=0;
    while ( rewoundFile.hasNext() && lineCounter != randomLineNumber ) {
      lineCounter++;
      randomQuestion = rewoundFile.nextLine();
    }
    return randomQuestion;
  } // method selectQuestionAtRandom

  public static void main(String[] args) throws FileNotFoundException {
    String fileWithQuestions = "questions.txt";
    String ourQuestionAtRandom = selectQuestionAtRandom(fileWithQuestions);
    System.out.println(ourQuestionAtRandom);
  }

}