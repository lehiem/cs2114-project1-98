import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * game class description
 *
 * @author verxnic
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

    // ~Public Methods ........................................................

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }


    // ----------------------------------------------------------
    /**
     * Starts and controls game flow.
     * 
     */

    public void startGame() {

        methods = new GameMethods();
        validator = new InputValidator();

        boolean correctType = false;
        boolean validEntry = false;

        correctAnswer = methods.generateNumber();

        System.out.println("=================================");
        System.out.println("         CRACK THE CODE          ");
        System.out.println("=================================");
        System.out.println(
            "Welcome! Try to guess the secret five-digit number.");
        System.out.println();
        System.out.println("RULES:");
        System.out.println("1. Your guess must be exactly five digits.");
        System.out.println("2. Your guess must be a positive whole number.");
        System.out.println("3. Your guess cannot start with 0.");
        System.out.println("4. Enter your guess as a five-digit number only.");
        System.out.println("   Example: 12345");
        System.out.println(
            "5. Do not use brackets, spaces, decimals, or other symbols.");

        while (playing) {

            String userInput = promptGuess();

            correctType = validator.isInteger(userInput);
            validEntry = validator.isValidGuess(userInput);

            while (!correctType || !validEntry) {

                if (!correctType) {
                    System.out.println(
                        "Invalid input. Please enter a whole number.");
                    System.out.println("Example: 12345");
                }

                if (!validEntry) {
                    System.out.println(
                        "Invalid guess. Your guess must be a positive five-digit number, and cannot start with 0.");
                    System.out.println("Example: 12345");
                }

                userInput = promptGuess();
                correctType = validator.isInteger(userInput);
                validEntry = validator.isValidGuess(userInput);
            }

            guess = Integer.parseInt(userInput);

            boolean winner = methods.isCorrect(guess, correctAnswer);

            if (winner) {
                playing = false;
                System.out.println();
                System.out.println("=================================");
                System.out.println("          YOU WIN!               ");
                System.out.println("=================================");
                System.out.println(
                    "Congratulations! You guessed the secret number!");
                System.out.println("The answer was " + correctAnswer + ".");
                System.out.println("Thanks for playing!");
                break;
            }

            else {
                correctPositions = methods.getCorrectPositions(guess,
                    correctAnswer);
                System.out.println(
                    "The following numbers are in the correct position: ");
                System.out.println(correctPositions);

                optionSelected = showOptions();
                boolean validOption = validator.isValidOption(optionSelected);

                while (!validOption) {
                    System.out.println("wrong option error message ");
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
