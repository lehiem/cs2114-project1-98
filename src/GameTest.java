import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the Game class.
 *
 * @author Veronica Munoz Ospina
 * @version 2026.09.25
 */
public class GameTest extends TestCase {

    // ~ Fields ................................................................
    private Game game;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    /**
     * Sets up the test object.
     */
    public void setUp() {
        game = new Game();
    }


    /**
     * Tests the promptGuess method.
     */
    public void testPromptGuess() {
        game.scanner = new java.util.Scanner("12345");
        assertEquals("12345", game.promptGuess());
    }


    /**
     * Tests the showOptions method.
     */
    public void testShowOptions() {
        game.scanner = new java.util.Scanner("a");
        game.scanner = new java.util.Scanner("b");
        game.scanner = new java.util.Scanner("c");
        game.scanner = new java.util.Scanner("d");

        assertEquals("a", game.showOptions());
        assertEquals("b", game.showOptions());
        assertEquals("c", game.showOptions());
        assertEquals("d", game.showOptions());

    }
}
