/**
 * Checks if the input provided by the user is valid before continuing with the game
 *
 * @author lehiem
 * @version Sep 23, 2026
 */
public class InputValidator {

    // ----------------------------------------------------------

    /**
     * checks if the input is an integer
     * @param input String that represents user input
     * @return true if can be converted and false if cannot be
     */
    public boolean isInteger(String input) {

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
     * checks if the user inputs a valid guess meaning a five digit number
     * @param input
     * @return true or false
     */
    public boolean isValidGuess(String input) {

        if (input == null || input.length() != 5) {

            return false;

        }
        
        if (input.charAt(0) == '0') {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {

            if (!Character.isDigit(input.charAt(i))) {

                return false;

            }

        }

        return true;

    }

    // ----------------------------------------------------------

    /**
     * checks if the user inputs a valid option a,b,c,d, or e
     * @param option
     * @return true or false
     */
    public boolean isValidOption(String option) {

        if (option == null) {

            return false;

        }

        return option.equalsIgnoreCase("A") ||
               option.equalsIgnoreCase("B") ||
               option.equalsIgnoreCase("C") ||
               option.equalsIgnoreCase("D") ||
               option.equalsIgnoreCase("E");

    }

}
