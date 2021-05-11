import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 * Class to build the contents of the quiz
 */
public class QuestionsCollection {

    /**
     * The beginning of the collection. Every question can be found in relation
     * to this first question, by traversing the chain of questions created by
     * the Question.next field.
     */
    private Question firstQuestion = null;


    /**
     * The number of questions in this collection. Every time we add a question
     * to the collection, this number is updated +1.
     */
    private int numberOfQuestions;



    /**
     * Method to add a question to the collection
     */
    public void addQuestion(Question question) {
        if (firstQuestion == null) { // Collection is empty; let's start it
            firstQuestion = question; // make this the first question
            numberOfQuestions = 1; // initialize count
        } else { // Collection is not empty; let's find the last question in it.
            Question current = firstQuestion; // start from the first one
            while (current.hasNext()) { // get to the question that has no next question
                current = current.getNext();
            }
            /*
            At this point, current is the last question of the collection and
            we can append the new question here, as the current question's next
            object.
             */
            current.setNext(question);
            numberOfQuestions++; // increment count
        }
    } // method addQuestion


    /**
     * Method to find and return a question based on ID
     *
     * @param withID String of ID we are looking for
     * @return null if question with specified ID not found;
     * question object otherwise.
     */
    public Question findQuestion(String withID) {
        Question found = null; // assume question doesn't exist
        if (firstQuestion != null) { // collection is empty; don't bother
            Question current = firstQuestion; // prepare to traverse collection
            if (current.getID().equalsIgnoreCase(withID)) { // in case first question is the one
                found = current;
            } else { // when the first question is not the one we are looking
                while (current.getNext() != null) { // traversal loop until we reach end
                    if (current.getID().equalsIgnoreCase(withID)) {
                        found = current;
                    }
                    current = current.getNext();
                }
            }
        }
        return found;
    } // method findQuestion

    public Question findQuestion(int sequenceNumber) {
        Question result = null;
        if (sequenceNumber == 0) {
            result = firstQuestion;
        } else if (sequenceNumber > 0 && sequenceNumber < numberOfQuestions) {
            int counter = 1;
            Question current = firstQuestion;
            while (current.hasNext() && counter != sequenceNumber) {
                current = current.getNext();
                counter++;
            }
            result = current;
        }
        return result;
    } // method findQuestion


    /**
     * Method to load questions and answers from files. Default files are assumed
     * questions.txt, answers.txt
     * but method overloading allows us to specify any text file. For now we
     * expect files to be CSV with # as a delimiter. Actually, the files use
     * spaces around the delimiter for better readability, so the actual delimiter
     * is " # ".
     */
    public void loadData() {
        loadData("questions.txt", "answers.txt");
    }

    /**
     * Parameterized method for loading questions and answers from any file.
     *
     * @param questionsFileName String with file name for questions
     * @param answersFileName   String with file name for answers
     * @return false if file reading failed
     */
    public boolean loadData(String questionsFileName, String answersFileName) {
        boolean result = false;
        File questionsFile = new File(questionsFileName);
        File answersFile = new File(answersFileName);
        Scanner q; // Declare scanner for questions -- will initialize it later
        try {
            q = new Scanner(questionsFile); // scanner to questions
            while (q.hasNext()) { // scan the questions file, line-by-line
                String inputFromQuestions = q.nextLine(); // read a line
                String[] questionTokens = tokenize(" # ", inputFromQuestions); // tokenize it
                String questionID = questionTokens[0]; // first token is the question ID
                String questionText = questionTokens[1]; // second token is the question itself
                // Prepare a new question object
                Question newQuestion = new Question(questionID, questionText);
                /*
                Next, find all answers that match the question ID
                 */
                Scanner a;
                try {
                    a = new Scanner(answersFile); // scanner to answers
                    while (a.hasNext()) { // scan the answers file, line-by-line
                        String inputFromAnswers = a.nextLine(); // read a line
                        String[] answerTokens = tokenize(" # ", inputFromAnswers); // tokenize the line
                        String answerID = answerTokens[0]; // the answer's ID
                        double pythoness = Double.valueOf(answerTokens[1]); // answer's pythoness level
                        String answerText = answerTokens[2]; // the text of the answer
                        if (questionID.equalsIgnoreCase(answerID)) { // If IDs match
                            Answer newAnswer = new Answer(answerText, pythoness); // create Answer object
                            newQuestion.addAnswer(newAnswer); // add it to the question object.
                        }
                    } // loop for answersFile
                    a.close(); // close scanner to answers file
                } catch (Exception e) { // something went wrong with answers file
                    result = false; // signal failure
                } // try/catch for answers
                addQuestion(newQuestion); // Add new question object to the collection
                result = true; // signal success
            } // loop for questionsFile
            q.close(); // close scanner to questions file
        } catch (Exception e) { // something went wrong with questions file
            result = false; // signal failure
        } // try/catch for questions
        return result;
    } // method loadData


    /**
     * Helper method to tokenize a string along the occurrences of a delimiter.
     *
     * @param delimiter        The delimiter that separates values in the string
     *                         we wish to tokenize.
     * @param stringToTokenize The string to tokenize.
     * @return A string array with the tokens found.
     */
    public String[] tokenize(String delimiter, String stringToTokenize) {
        String[] tokens;
        /* There are N+1 tokens in a string with N delimiters */
        int numberOfTokens = 1 + countOccurrences(delimiter, stringToTokenize);
        if (numberOfTokens == 1) {
            tokens = new String[]{stringToTokenize}; // one element only
        } else { // in case of > 1 tokens
            /*
             * The next few lines look very similar to the traversal we do in
             * method countOccurrences; this redundancy is necessary because we
             * need to count first, then determine how many elements we need in
             * the array.
             *
             * Analysis for tokenization (with delimiter # or extended delim " # "
             *
             *          0123456789012345678901234567890...
             * content: aaaa # bbbbbb # cccccccccccc
             *          ^  ^         ^^^
             *          |  |          |
             *          |  |          delimiter has .length
             *          |  |
             *          |  +---- rightPosition for substring-ing; it is always set to
             *          |                                         the value of indexOf
             *          leftPosition for substring-ing,           of the delimiter
             *          always 0, because with each               within the current
             *          iteration the string is reduced           string.
             *          by removing a token from its
             *          beginning. For example, the string
             *          above will become
             *          "bbbbbb # cccccccccccc"
             *          and then "cccccccccccc"
             */
            tokens = new String[numberOfTokens]; // initialize the array of tokens
            int leftPosition = 0, rightPosition;
            int arrayElement = 0; // index for array of tokens we are building
            while (stringToTokenize.indexOf(delimiter) > 0) { // while input is still delimited
                rightPosition = stringToTokenize.indexOf(delimiter); // find where to cleave
                tokens[arrayElement] = stringToTokenize.substring(leftPosition, rightPosition); // cleave
                stringToTokenize = stringToTokenize.
                        substring(rightPosition + delimiter.length()); // reduce and repeat
                arrayElement++; // advance array index
            }
            tokens[arrayElement] = stringToTokenize; // last reduced string remaining is last token
        }
        return tokens; // return array of tokens
    } // method tokenize


    /**
     * Helper method to count the occurrences of a string within another string
     *
     * @param content String to search through it
     * @param pattern String to search for
     * @return the number of times pattern appears in content
     */
    public int countOccurrences(String pattern, String content) {
        int count = -0; // assume no occurrence
        if (content.indexOf(pattern, 0) > 0) {
            int currentPosition = 0; // start at the beginning of the string
            /*
            Keep looking for occurrences of the pattern from various locations in
            the pattern, moving forward. Because of the if-statement above, we
            know there will be at least one occurrence. We find it, then advance
            the search location forward of that occurrence.
             */
            while (content.indexOf(pattern, currentPosition) > 0) { // this will happen at least once
                count++; // increase count
                currentPosition = 1 + content.indexOf(pattern, currentPosition); // advance forward
            }
        }
        return count;
    } // method countOccurrences




    /**
     *
     */
    public void traverseCollection() {
        if (firstQuestion == null) {
            System.out.printf("\n\nNothing to traverse!\n");
        } else {
            System.out.printf("\n\nThere are %d questions in this collection.\n",numberOfQuestions);
            Question current = firstQuestion;
            while (current.hasNext()) {
                System.out.printf("\nQuestion: [%s]",current.getText());
                current = current.getNext();
            }
            System.out.printf("\nQuestion: [%s]",current.getText());
        }
    } // method traverseCollection


    /**
     * Method to mark all questions available. Useful for resetting the game.
     */
    public void makeAllAvailable() {
        if (firstQuestion != null) {
            Question current = firstQuestion;
            while (current.hasNext()) {
                current.setAvailable(); // setter changes field Question.isAvailable to true
                current=current.getNext();
            }
            current.setAvailable();
        }
    } // method makeAllAvailable


    /**
     * Method to remove a Question object from the chain. The method goes down the
     * chain of questions looking for the object we wish to delete.
     *
     *
     *  +----------+              +-------------+              +----------+
     *  | previous | -- .next --> | question to | -- .next --> | next     |
     *  | question |              | delete      |              | question |
     *  +----------+              +-------------+              +----------+
     *        |                                                    |
     *        +-->-- reroute .next pointer from question ------>---+
     *               to delete, to the question after it!
     *
     * When traversing the chain, by moving from firstQuestion to its .next etc,
     * we also need to keep track of the previous question. So that when the
     * question to be deleted is found, and its previous question is known, we can
     * perform the reassignment:
     *
     *    previousQuestion.next = questionToDelete.next
     *
     * There are two "edge" scenarios, i.e., situations where the reassignment
     * above is not straightforward:
     *
     * 1 - what if the questionToDelete is the firstQuestion in the chain?
     *
     *     In this case the question after the firstQuestion becomes the new
     *     firstQuestion, i.e,
     *     firstQuestion = firstQuestion.next;
     *
     * 2 - what if the questionToDelete is the last question in the chain and
     *     therefore its .next is null?
     *
     *     In this case, the previous question's .next field is set to null, i.e.,
     *     previousQuestion.next = null;
     *
     * @param questionToDelete Question object to delete
     * @return false if removal fails because chain is empty or question not found
     */
    public boolean removeQuestion(Question questionToDelete) {
        boolean success = false;
        if (questionToDelete != null && firstQuestion != null) { // chain and question not empty
            if (questionToDelete.equals(firstQuestion)) { // is it the first question?
                firstQuestion = firstQuestion.getNext(); // Make its next question the first question
                success = true; // signal success
            } else { // question to delete is not the first one; need to traverse the chain
                Question current = firstQuestion.getNext(); // first is not the one to delete, start with next
                Question previousQuestion = firstQuestion; // pointer for the previous question
                while (current.hasNext() && !success) { // loop runs to end of chain, or successful finding
                    if (current.equals(questionToDelete)) { // found it!
                        previousQuestion.setNext(current.getNext()); // bypass current question
                        success = true; // signal success; also stops while loop
                    }
                    previousQuestion = current; // advance the pointer for previousQuestion
                    current = current.getNext(); // advance the pointer for current question
                } // while loop
                /*
                The while loop above does include the last question because its .next is null
                and the loop will not run on it. So, if at this point success=false, it is possible
                that the question to delete is the last question in the chain. One more check to perform.
                The current pointer is now at the last question in the chain and that makes the
                check easy to perform.
                 */
                if (!success && current.equals(questionToDelete)) { // is it the last question?
                    previousQuestion.setNext(null); // set previousQuestion's .next to null
                    success = true; // signal success
                }
            } // if: is questionToDelete the first question?
        } // if: is questiontToDelete null? Is chain empty?
        numberOfQuestions = (success) ? numberOfQuestions-1: numberOfQuestions; // reduce by 1 if successful removal
        return success;
    } // method removeQuestion

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    /**
     * quick test
     */
    public static void main(String[] args) {
        QuestionsCollection quiz = new QuestionsCollection();
        quiz.loadData();
        quiz.traverseCollection();
    }

}
