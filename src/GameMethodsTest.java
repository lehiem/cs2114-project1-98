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
}
