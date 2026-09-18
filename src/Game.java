// -------------------------------------------------------------------------
/**
 * game class description
 *
 * @author
 * @version
 */
public class Game {
    // ~ Fields ................................................................
    int answer;
    int guess;
    String option;
    InputValidator validator;
    GameMethods methods;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * method descp.
     * 
     * @return 
     */
    public void startGame() {
    methods = new GameMethods();
    validator = new InputValidator(); 
        
    boolean correctType = false;
    boolean validEntry = false;
        
    System.out.println("Intro Message");
    System.out.println("Rules");
    
    String userInput = promptGuess();
    
    while (!correctType || !validEntry) {
    correctType = isInteger();
    validEntry = isValidGuess();
    
    if (!correctType) {
    System.out.println("");
    userInput = promptGuess();
    }
    
    else 
    
    
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
