public class GameMethodsTest extends student.TestCase
{
    private GameMethods methods;
    
    public void setUp()
    {
        methods = new GameMethods();
    }
    
    public void testGenerateNumberIsFiveDigits()
    {
        for (int i = 0; i < 1000; i++)
        {
            int number = methods.generateNumber();
            assertTrue(number >= 10000 && number <= 99999);
        }
    }
    
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
    
    public void testIsCorrectMatch()
    {
        assertTrue(methods.isCorrect(12345, 12345));
    }
    
    public void testIsCorrectNotMatch()
    {
        assertFalse(methods.isCorrect(12345, 54321));
    }
}
