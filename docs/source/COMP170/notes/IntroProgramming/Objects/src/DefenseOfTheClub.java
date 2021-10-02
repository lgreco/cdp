import java.util.Locale;
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

    private Scanner keyboard = new Scanner(System.in);


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
        System.out.printf("\n\nBased on the answer above, what's the likelihood his person is a Python infiltrator? (0.0 - 1.0) ");
        double userGuess = keyboard.nextDouble();
        //keyboard.close();
        return userGuess;
    }


    /**
     * Play a round of the game.
     *
     * @param numberOfQuestionsToAsk how many questions to ask
     */
    public void play(int numberOfQuestionsToAsk) {
        loadQuestions();
        copyToWorking();
        if (numberOfQuestionsToAsk > 0 && numberOfQuestionsToAsk <= principalCopy.getNumberOfQuestions()) {
            double playerScore = 0.0; // player score -- captures player's assessment of (suspect) guest
            double systemScore = 0.0; // system score -- capture's known assessment based on answer's pythoness
            for (int gameRound = 0; gameRound < numberOfQuestionsToAsk; gameRound++) {
                Question askThisQuestion = randomQuestion();
                double pythonessValue = askThisQuestion.displayQuestion();
                playerScore += userAnswer(); // update
                systemScore += pythonessValue; // update
            }
            playerScore = playerScore/numberOfQuestionsToAsk;
            systemScore = systemScore/numberOfQuestionsToAsk;
            System.out.printf("\n\n\nAccording to your estimation, the probability the guest is a Python infiltrator is %.0f%%.\nWould you admit the guest to the club? (y/n) ",playerScore*100);
            String admit = keyboard.next();
            System.out.printf("\n\nLet's see how well you did ...\n");
            System.out.printf("\n\nAccording to the algorithm the probability this is an infiltrator is %.2f",systemScore);
            if (admit.toLowerCase().equals("y") || admit.toLowerCase().equals("yes")) {
                if (systemScore>0.50) {
                    System.out.printf("\n\nCongratulations (not!). You just allowed an infiltrator to join the club meeting.");
                } else {
                    System.out.printf("\n\nGood job! You admitted a legitimate member.");
                }
            } else {
                if (systemScore>0.50) {
                    System.out.printf("\n\nGood job! You successfully stopped an infiltrator from joining the club meeting");
                } else {
                    System.out.printf("\n\nBummer! You just stopped a legitimate member from joining the club meeting.");
                }
            }
        }
    } // method play

    public static void main(String[] args) {
        DefenseOfTheClub newGame = new DefenseOfTheClub();
        newGame.play(1);
    }
}
