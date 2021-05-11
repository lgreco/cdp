import java.util.Random;
import java.util.Scanner;

public class DefenseOfTheClub {

    /**
     * The principal copy of the questions collection.
     */
    private QuestionsCollection principalCopy = new QuestionsCollection();


    /**
     * Working copy of the questions collection.
     */
    private QuestionsCollection workingCopy; // local copy of questions


    /**
     * Method to load questions to the principal collection.
     */
    public void loadQuestions() {
        principalCopy.loadData();
    } // method loadQuestions


    /**
     * Make a local copy of the questions collection. We'll be using the local
     * copy to pull questions (and delete them). When we need to run a fresh game
     * we can copy the principal collection to the local again.
     */
    public void copyToWorking() {
        workingCopy = principalCopy;
    } // method copyToWorking


    /**
     * Method to select a question at random. The question is pulled from the
     * local copy of the QuestionCollection object, then it is deleted. That
     * way there is no chance that it will be pulled again during the game
     * session.
     *
     * @return null if no questions are available
     */
    public Question randomQuestion() {
        Question question = null;
        int remainingQuestions = workingCopy.getNumberOfQuestions();
        if (remainingQuestions > 0) { // make sure we have questions left to use
            Random rng = new Random();
            int sequenceNumber = rng.nextInt(remainingQuestions); // random sequence
            question = workingCopy.findQuestion(sequenceNumber); // pull the question
            workingCopy.removeQuestion(question); // then delete it
        }
        return question;
    } // method randomQuestion

    public double userAnswer() {
        Scanner keyboard = new Scanner(System.in);
        System.out.printf("\n\n\tBased on the answer above, what's the likelihood\n\tthis person is a Python infiltrator? (0.0 - 1.0) ");
        double userGuess = keyboard.nextDouble();
        //keyboard.close();
        return userGuess;
    }


    /**
     *
     * @param numberOfQuestionsToAsk
     */
    public void play(int numberOfQuestionsToAsk) {
        loadQuestions();
        copyToWorking();
        if (numberOfQuestionsToAsk > 0 && numberOfQuestionsToAsk <= principalCopy.getNumberOfQuestions()) {
            double playerScore = 0.0;
            double systemScore = 0.0;
            for (int gameRound = 0; gameRound < numberOfQuestionsToAsk; gameRound++) {
                Question askThisQuestion = randomQuestion();
                double pythonessValue = askThisQuestion.displayQuestion();
                playerScore += userAnswer();
                systemScore += pythonessValue;
            }
            System.out.printf("\n\n\nLet's see how well you did ...\n");
            playerScore = playerScore/numberOfQuestionsToAsk;
            systemScore = systemScore/numberOfQuestionsToAsk;
            System.out.printf("\n\tChances that his guest is an infiltrator:\n");
            System.out.printf("\n\t\tAccording to the algorithm: %4.2f",systemScore);
            System.out.printf("\n\t\t          According to you: %4.2f",playerScore);

        }
    } // method play

    public static void main(String[] args) {
        DefenseOfTheClub newGame = new DefenseOfTheClub();
        newGame.play(5);
    }
}
