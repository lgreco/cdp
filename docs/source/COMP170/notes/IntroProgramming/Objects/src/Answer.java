/**
 * Class for answers to the quiz questions. Each answer contains its text
 * and a "pythoness" value assessing how likely it is to be given by a
 * Python infiltrator. Answer objects are linked directly to their
 * corresponding questions, so there is to need to maintain question and
 * answer IDs as we've done in previous implementations of the game.
 */
public class Answer {

    /** The contents of the answer */
    private String text;
    /** Pythoness level for the answer */
    private double pythoness;
    /** What's the next answer in this collection? null to end chain */
    private Answer next;

    /**
     * Small constructor for answer
     */
    public Answer(String text, double pythoness) {
        this.text = text;
        this.pythoness = pythoness;
        this.next = null; // we'll add it later
    } // Constructor Answer

    /** Mutator for this.next */
    public void setNext(Answer next) {
        this.next = next;
    } // method setNext

    /** Accessors */

    public boolean hasNext() { return next != null; }

    public String getText() {
        return text;
    }

    public double getPythoness() {
        return pythoness;
    }

    public Answer getNext() {
        return next;
    }
}
