// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author lehie
 *  @version Sep 23, 2026
 */
public class InputValidator {
    // ----------------------------------------------------------
    /**
     * isIntger checks if the input is an integer
     * @param input String that represent user input
     * @return true if can be convert and false if cannot be
     */
    public boolean isIntger(String input ) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException error) {
            return false;
        }
    }
    
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param input
     * @return
     */
    public boolean isVaild(String input) {
        
    }

}
