import java.util.Random;

/**
 * Class to build quiz questions. Each question contains a point to the next
 * question in the collection, as well as at least one answer object.
 */
public class Question {

    /** The unique identifier for the question */
    private String ID;
    /** The contents of the question */
    private String text;
    /** Next question in the collection */
    private Question next;
    /** Is this question available (when used in a quiz)? */
    private boolean isAvailable;
    /** First answer in the collection of answers to this question */
    private Answer firstAnswer = null;
    /** Now many answers we have here? */
    private int numberOfAnswers;

    /**
     * Small constructor for question
     */
    public Question(String ID, String text) {
        this.ID = ID;
        this.text = text;
        this.next = null; // leave it null; we'll add it later
        this.firstAnswer = null; // leave it null; we'll add it later
        this.isAvailable = true;
        this.numberOfAnswers=0;
    } // Constructor Question

    /**
     * Method to add an answer to this question.
     */
    public void addAnswer(Answer answer) {
        if (firstAnswer==null) {
            firstAnswer=answer;
            numberOfAnswers++;
        } else {
            Answer current = firstAnswer;
            while (current.getNext()!=null) {
                current=current.getNext();
            }
            /* current is now at the last answer for this question */
            current.setNext(answer);
            numberOfAnswers++;
        }
    } // method addAnswer


    /**
     * Displays the contents of a question, selects one of the question's answers
     * at random, displays the answer, and returns the answer's pythoness.
     *
     * @return double with pythoness value
     */
    public double displayQuestion() {
        double pythonessValue=-1.0;
        System.out.printf("\n\nYou ask: %s\n",text);
        // get answer at random
        Random rng = new Random();
        int r = rng.nextInt(numberOfAnswers);
        Answer currentAnswer = firstAnswer;
        int count = 0;
        while (currentAnswer.hasNext() && count != r) {
            currentAnswer = currentAnswer.getNext();
            count++;
        }
        System.out.printf("\nAnd the guest answers: %s", currentAnswer.getText());
        return currentAnswer.getPythoness();
    } // method displayQuestion


    public boolean hasNext() {
        return next!=null;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public boolean isNotAvailable() {
        return !isAvailable;
    }




    /** Mutators for this.next and this.firstAnswer */
    public void setNext(Question next) {
        this.next = next;
    } // method setNext

    public String getText() {
        return text;
    }

    public void setAvailable() {
        setAvailable(true);
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /** Accessors */


    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public Question getNext() {
        return next;
    }

    public String getID() {
        return ID;
    }
}
