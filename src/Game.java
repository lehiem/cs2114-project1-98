import java.util.ArrayList;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * Controls and gives structure to "Crack The Code" guessing game.
 *
 * @author VeronicaM
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

    Scanner scanner = new Scanner(System.in);

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates game object to start game
     * 
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }


    // ----------------------------------------------------------
    /**
     * Starts game and controls the flow.
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
        System.out.println("Press enter to continue.");
        scanner.nextLine();

        System.out.println("RULES:");
        System.out.println("1. Your guess must be exactly five digits.");
        System.out.println("2. Your guess must be a positive whole number.");
        System.out.println("3. Your guess cannot start with 0.");
        System.out.println("4. Enter your guess as a five-digit number only.");
        System.out.println("   Example: 12345");
        System.out.println(
            "5. Do not use brackets, spaces, decimals, or other symbols.");
        System.out.println("Press enter to continue.");
        scanner.nextLine();

        while (playing) {

            String userInput = promptGuess();
            System.out.println();

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
                        "Invalid guess. Your guess must be a positive five-digit "
                            + "number, and it cannot start with 0.");
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
            }

            else {
                correctPositions = methods.getCorrectPositions(guess,
                    correctAnswer);
                System.out.println(
                    "The following numbers are in the correct position: ");
                System.out.println(correctPositions);

                System.out.println("Press enter to continue.");
                scanner.nextLine();

                optionSelected = showOptions();
                boolean validOption = validator.isValidOption(optionSelected);

                while (!validOption) {
                    System.out.println("Invalid option. Choose one from the "
                        + "following:");
                    optionSelected = showOptions();
                    validOption = validator.isValidOption(optionSelected);
                }

                if (optionSelected.equals("a")) {
                    int firstDigit = methods.getFirstDigit(correctAnswer);
                    System.out.println("The first digit of the number is: "
                        + firstDigit);
                }

                else if (optionSelected.equals("b")) {
                    int lastDigit = methods.getLastDigit(correctAnswer);
                    System.out.println("The last digit of the number is: "
                        + lastDigit);
                }

                else if (optionSelected.equals("c")) {
                    int sumOfDigits = methods.getDigitsSum(correctAnswer);
                    System.out.println(
                        "The sum of the digits of the number is: "
                            + sumOfDigits);
                }

                else if (optionSelected.equals("d")) {
                    playing = false;
                    methods.giveUp(correctAnswer);
                    break;
                }

            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Prompts the user to enter a guess and returns the input.
     * 
     * @return user's guess as String
     */
    public String promptGuess() {
        System.out.println();
        System.out.print("Enter your guess: ");
        return scanner.nextLine();
    }


    // ----------------------------------------------------------
    /**
     * Displays the available game options and returns the user's choice.
     * 
     * @return user's selected option as String
     */
    public String showOptions() {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("a) Get the first digit");
        System.out.println("b) Get the last digit");
        System.out.println("c) Get the sum of the digits");
        System.out.println("d) Give up and reveal the answer");
        System.out.println("e) Guess without receiving a hint");

        System.out.println();
        System.out.print("Enter your choice: ");
        return scanner.nextLine();
    }

}
