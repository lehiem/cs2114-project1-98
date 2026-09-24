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

    public GameMethods()
    {
        random = new Random();
    }

    // ~Public Methods ........................................................


    public int generateNumber()
    {
        return 10000 + random.nextInt(90000);

    }


    public boolean isCorrect(int guess, int answer)
    {
        return guess == answer;
    }


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


    public int getFirstDigit(int answer)
    {
        return 
    }


    public int getLastDigit(int answer)
    {
        return
    }


    public int getDigitsSum(int answer)
    {
        return
    }


    public String giveUp(int answer)
    {
        return
    }
}
