import java.util.ArrayList;
import java.util.Arrays;

// -------------------------------------------------------------------------
/**
 * Class for testing all methods in the GameMethods class. Tests the
 * generateNumber, isCorrect, getCorrectPositions, getFirstDigit, getLastDigit,
 * getDigitsSum, and getDigitsSum methods.
 * 
 * @author JustisP
 * @version 9.23.2026
 */
public class GameMethodsTest
    extends student.TestCase
{
    private GameMethods methods;

    public void setUp()
    {
        methods = new GameMethods();
    }


    // ----------------------------------------------------------
    /**
     * Test method for generateNumber. Generated number should be exactly 5
     * digits.
     */
    public void testGenerateNumberIsFiveDigits()
    {
        for (int i = 0; i < 1000; i++)
        {
            int number = methods.generateNumber();
            assertTrue(number >= 10000 && number <= 99999);
        }
    }


    // ----------------------------------------------------------
    /**
     * Test method for generateNumber. Generated number should not start with
     * zero or a negative number.
     */
    public void testGenerateNumberLeadingZeroOrNegative()
    {
        for (int i = 0; i < 1000; i++)
        {
            int number = methods.generateNumber();
            assertTrue(number > 0);
            assertFalse(String.valueOf(number).startsWith("0"));
            assertEquals(5, String.valueOf(number).length());
        }
    }


    // ----------------------------------------------------------
    /**
     * Test method for isCorrectMatch. Should return true when the numbers
     * match.
     */
    public void testIsCorrectMatch()
    {
        assertTrue(methods.isCorrect(12345, 12345));
    }


    // ----------------------------------------------------------
    /**
     * Test method for isCorrectMatch. Should return true when the numbers
     * match.
     */
    public void testIsCorrectNotMatch()
    {
        assertFalse(methods.isCorrect(12345, 54321));
    }


    // ----------------------------------------------------------
    /**
     * Test method for getCorrectPositions. Should return the correct positions
     * in an ArrayList when some digits in the guess match the answer.
     */
    public void testGetCorrectPositionsSomeMatch()
    {
        ArrayList<Integer> expected =
            new ArrayList<>(Arrays.asList(1, 2, 4, 5));
        assertEquals(expected, methods.getCorrectPositions(12345, 12945));
    }


    // ----------------------------------------------------------
    /**
     * Test method for getCorrectPositions. Should return an empty ArrayList
     * when no digits in the guess match the answer.
     */
    public void testGetCorrectPositionsNoMatch()
    {
        assertTrue(methods.getCorrectPositions(11111, 22222).isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Test method for getCorrectPositions. Should return the correct positions
     * in an ArrayList when all digits in the guess match the answer.
     */
    public void testGetCorrectPositionsAllMatch()
    {
        ArrayList<Integer> expected =
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(expected, methods.getCorrectPositions(12345, 12345));
    }


    // ----------------------------------------------------------
    /**
     * Test method for getFirstDigit. Should return the first digit of the
     * answer.
     */
    public void testGetFirstDigit()
    {
        assertEquals(5, methods.getFirstDigit(54321));
        assertEquals(1, methods.getFirstDigit(10000));
    }


    // ----------------------------------------------------------
    /**
     * Test method for getLastDigit. Should return the last digit of the answer.
     */
    public void testGetLastDigit()
    {
        assertEquals(1, methods.getLastDigit(54321));
        assertEquals(0, methods.getLastDigit(12340));
    }


    // ----------------------------------------------------------
    /**
     * Test method for getDigitsSum. Should return the sum of all the digits in
     * the answer.
     */
    public void testGetDigitsSum()
    {
        assertEquals(15, methods.getDigitsSum(12345));
        assertEquals(1, methods.getDigitsSum(10000));
    }

}
