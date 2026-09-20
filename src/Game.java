import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * game class description
 *
 * @author
 * @version 09.18.2026
 */
public class Game {
    // ~ Fields ................................................................
    int correctAnswer;
    int guess;
    String optionSelected;

    boolean playing = true;
    ArrayList<Integer> correctPositions = new ArrayList<>();

    InputValidator validator;
    GameMethods methods;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * method description.
     * 
     * @return
     */
    public void startGame() {

        methods = new GameMethods();
        validator = new InputValidator();

        boolean correctType = false;
        boolean validEntry = false;

        correctAnswer = methods.generateNumber();

        System.out.println("Intro Message");
        System.out.println("Rules");

        while (playing) {

            String userInput = promptGuess();

            correctType = validator.isInteger(userInput);
            validEntry = validator.isValidGuess(userInput);

            while (!correctType || !validEntry) {

                if (!correctType) {
                    System.out.println("");
                }

                if (!validEntry) {
                    System.out.println("");
                }

                userInput = promptGuess();
                correctType = validator.isInteger(userInput);
                validEntry = validator.isValidGuess(userInput);
            }

            guess = Integer.parseInt(userInput);

            boolean winner = methods.isCorrect(guess, correctAnswer);

            if (winner) {
                playing = false;
                System.out.println("win message");
                break;
            }

            else {
                correctPositions = methods.getCorrectPositions(guess,
                    correctAnswer);
                System.out.println("correctPositions");

                optionSelected = showOptions();
                boolean validOption = validator.isValidOption(optionSelected);

                while (!validOption) {
                    System.out.println("wrong option error message");
                    optionSelected = showOptions();
                    validOption = validator.isValidOption(optionSelected);
                }

                if (optionSelected.equals("a")) {
                    int firstDigit = methods.getFirstDigit(correctAnswer);
                    System.out.println("first digit: ");
                }

                else if (optionSelected.equals("b")) {
                    int lastDigit = methods.getLastDigit(correctAnswer);
                    System.out.println("last digit: ");
                }

                else if (optionSelected.equals("c")) {
                    int sumOfDigits = methods.getDigitsSum(correctAnswer);
                    System.out.println("sum of digits: ");
                }

                else {
                    playing = false;
                    System.out.println("give up message");
                    break;
                }

            }
        }
    }


    // ----------------------------------------------------------
    /**
     * method descp.
     * 
     * @return
     */
    public String promptGuess() {

    }


    // ----------------------------------------------------------
    /**
     * method descp.
     * 
     * @return
     */
    public String showOptions() {

    }

}
