import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * game class description
 *
 * @author
 * @version
 */
public class Game {
    // ~ Fields ................................................................
    int correctAnswer;
    int guess;
    String option;
    
    boolean playing = true;
    ArrayList<Integer> correctPositions = new ArrayList<>();
    
    InputValidator validator;
    GameMethods methods;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * method description.
     * 
     * @return 
     */
    public void startGame() {
        
        Game game = new Game();
        methods = new GameMethods();
        validator = new InputValidator(); 
        
        boolean correctType = false; 
        boolean validEntry = false;
        
        correctAnswer = methods.generateNumber();
    
        System.out.println("Intro Message");
        System.out.println("Rules");
    
        String userInput = promptGuess();
        
        correctType = validator.isInteger(userInput);
        validEntry = validator.isValidGuess(userInput);
        
        while (!correctType || !validEntry) {
    
            if (!correctType) {
                System.out.println("");
             }
            
            if (!validEntry) {
                System.out.println("");
            }
            
            userInput = promptGuess();
            correctType = validator.isInteger(userInput);
            validEntry = validator.isValidGuess(userInput);
        }
        
        guess = Integer.parseInt(userInput);
        
        boolean winner = methods.isCorrect(guess, correctAnswer);
        
        while(playing) {
            if (winner) {
                System.out.println("win message");
            }
            else{
               correctPositions = methods.getCorrectPositions();
               System.out.println("");
               
               option = game.showOptions();
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
