import java.util.ArrayList;
import java.util.Random;

// -------------------------------------------------------------------------
/**
 * Does the calculations and operations used in the game.
 *
 * @author justisp
 * @version 09.23.2026
 */
public class GameMethods
{
    // ~ Fields ................................................................

    private Random random;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a GameMethods object with a random number generator.
     */
    public GameMethods()
    {
        random = new Random();
    }

    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Generates a random five-digit number that never starts with zero.
     *
     * @return the random five-digit number
     */
    public int generateNumber()
    {
        return 10000 + random.nextInt(90000);

    }


    // ----------------------------------------------------------
    /**
     * Compares the user's guess to the correct answer.
     *
     * @param guess
     *            the user's guess
     * @param answer
     *            the correct answer
     * @return true if the guess equals the answer, false if it does not
     */
    public boolean isCorrect(int guess, int answer)
    {
        return guess == answer;
    }


    // ----------------------------------------------------------
    /**
     * Finds the positions where the guess matches the answer. The positions are
     * 1 to 5 from left to right.
     *
     * @param guess
     *            the user's guess
     * @param answer
     *            the correct answer
     * @return a list of the positions (1 to 5) where the digits match
     */
    public ArrayList<Integer> getCorrectPositions(int guess, int answer)
    {
        ArrayList<Integer> positions = new ArrayList<>();
        String guessString = String.valueOf(guess);
        String answerString = String.valueOf(answer);
        int length = Math.min(guessString.length(), answerString.length());
        for (int i = 0; i < length; i++)
        {
            if (guessString.charAt(i) == answerString.charAt(i))
            {
                positions.add(i + 1);
            }
        }
        return positions;
    }


    // ----------------------------------------------------------
    /**
     * Gets the first digit of the answer.
     *
     * @param answer
     *            the correct answer
     * @return the first digit of the answer
     */
    public int getFirstDigit(int answer)
    {
        String answerString = String.valueOf(Math.abs(answer));
        return answerString.charAt(0) - '0';
    }


    // ----------------------------------------------------------
    /**
     * Gets the last digit of the answer.
     *
     * @param answer
     *            the correct answer
     * @return the last digit of the answer
     */
    public int getLastDigit(int answer)
    {
        return Math.abs(answer) % 10;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the sum of all the digits in the answer.
     *
     * @param answer
     *            the correct answer
     * @return the sum of the digits of the answer
     */
    public int getDigitsSum(int answer)
    {
        int remaining = Math.abs(answer);
        int sum = 0;
        while (remaining > 0)
        {
            sum += remaining % 10;
            remaining /= 10;
        }
        return sum;
    }


    // ----------------------------------------------------------
    /**
     * Creates the message that reveals the answer when the user gives up.
     *
     * @param answer
     *            the correct answer
     * @return a message showing the correct answer
     */
    public String giveUp(int answer)
    {
        return "You gave up. The secret number was " + answer + ".";
    }
}
