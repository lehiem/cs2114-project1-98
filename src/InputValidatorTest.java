// -------------------------------------------------------------------------
/**
 *  Tests the InputValidator Class
 * 
 *  @author lehiem
 *  @version Sep 25, 2026
 */
public class InputValidatorTest
    extends student.TestCase
{
    private InputValidator validator;
    
    public void setUp() {
        validator = new InputValidator();
        
    }
    
    // ----------------------------------------------------------
    /**
     * tests IsInteger method
     */
    public void testIsInteger() {
        assertTrue(validator.isInteger("12345")); 
        assertTrue(validator.isInteger("0"));
        assertTrue(validator.isInteger("-25")); 
        assertFalse(validator.isInteger("hello")); 
        assertFalse(validator.isInteger("12.5")); 
        assertFalse(validator.isInteger(""));
    }
    
    // ----------------------------------------------------------
    /**
     * tests IsValidGuess method
     */
    public void testIsValidGuess() {
        assertTrue(validator.isValidGuess("12345"));
        assertFalse(validator.isValidGuess("01234"));
        assertFalse(validator.isValidGuess("1234")); 
        assertFalse(validator.isValidGuess("123456"));
        assertFalse(validator.isValidGuess("12A45"));
        assertFalse(validator.isValidGuess("12.45")); 
        assertFalse(validator.isValidGuess(null));
    }
    
    // ----------------------------------------------------------
    /**
     * test IsVaildOption method
     */
    public void testIsValidOption() {
        assertTrue(validator.isValidOption("A"));
        assertTrue(validator.isValidOption("B")); 
        assertTrue(validator.isValidOption("C")); 
        assertTrue(validator.isValidOption("D"));
        assertTrue(validator.isValidOption("E"));
        assertTrue(validator.isValidOption("a"));
        assertTrue(validator.isValidOption("e"));
        assertFalse(validator.isValidOption("F"));
        assertFalse(validator.isValidOption("1"));
        assertFalse(validator.isValidOption("ABC")); 
        assertFalse(validator.isValidOption(""));
        assertFalse(validator.isValidOption(null));
    }
}
