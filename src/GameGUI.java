import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Graphical interface for Crack the Code.
 *
 * Green means the digit is in the correct position.
 * Red means the digit is not in the correct position.
 *
 * @author Ben Seyoum
 * @version 09.25.2026
 */
public class GameGUI
{
    private static final Color CORRECT_COLOR =
        new Color(83, 141, 78);

    private static final Color INCORRECT_COLOR =
        new Color(180, 60, 60);

    private JFrame window;
    private JTextField guessField;
    private JLabel statusLabel;
    private JPanel historyPanel;

    private JButton guessButton;
    private JButton firstDigitButton;
    private JButton lastDigitButton;
    private JButton sumButton;
    private JButton giveUpButton;

    private GameMethods methods;
    private InputValidator validator;

    private int correctAnswer;
    private boolean playing;


    /**
     * Creates a new graphical Crack the Code game.
     */
    public GameGUI()
    {
        methods = new GameMethods();
        validator = new InputValidator();

        correctAnswer = methods.generateNumber();
        playing = true;

        buildWindow();
    }


    /**
     * Builds the game window.
     */
    private void buildWindow()
    {
        window = new JFrame("Crack the Code");

        window.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);

        window.setLayout(
            new BorderLayout(10, 10));


        // ---------------- TITLE ----------------

        JPanel headingPanel = new JPanel();

        headingPanel.setLayout(
            new BoxLayout(
                headingPanel,
                BoxLayout.Y_AXIS));

        JLabel title =
            new JLabel(
                "CRACK THE CODE",
                SwingConstants.CENTER);

        title.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                28));

        title.setAlignmentX(
            JLabel.CENTER_ALIGNMENT);

        JLabel rules =
            new JLabel(
                "Enter a positive five-digit number. "
                    + "Green = correct position. "
                    + "Red = incorrect position.",
                SwingConstants.CENTER);

        rules.setAlignmentX(
            JLabel.CENTER_ALIGNMENT);

        headingPanel.add(
            Box.createVerticalStrut(10));

        headingPanel.add(title);

        headingPanel.add(
            Box.createVerticalStrut(5));

        headingPanel.add(rules);

        headingPanel.add(
            Box.createVerticalStrut(10));

        window.add(
            headingPanel,
            BorderLayout.NORTH);


        // ---------------- GUESS HISTORY ----------------

        historyPanel = new JPanel();

        historyPanel.setLayout(
            new BoxLayout(
                historyPanel,
                BoxLayout.Y_AXIS));

        historyPanel.setBorder(
            BorderFactory.createEmptyBorder(
                10,
                20,
                10,
                20));

        JScrollPane historyScroll =
            new JScrollPane(historyPanel);

        historyScroll.setPreferredSize(
            new Dimension(500, 300));

        window.add(
            historyScroll,
            BorderLayout.CENTER);


        // ---------------- CONTROLS ----------------

        JPanel controls = new JPanel();

        controls.setLayout(
            new BoxLayout(
                controls,
                BoxLayout.Y_AXIS));

        controls.setBorder(
            BorderFactory.createEmptyBorder(
                5,
                20,
                15,
                20));


        JPanel guessPanel = new JPanel();

        guessField =
            new JTextField(10);

        guessField.setFont(
            new Font(
                "Monospaced",
                Font.BOLD,
                20));

        guessField.setHorizontalAlignment(
            JTextField.CENTER);


        guessButton =
            new JButton("Guess");

        guessButton.addActionListener(
            event -> submitGuess());

        guessField.addActionListener(
            event -> submitGuess());


        guessPanel.add(
            new JLabel("Five-digit guess:"));

        guessPanel.add(guessField);

        guessPanel.add(guessButton);


        // ---------------- HINT BUTTONS ----------------

        JPanel hintPanel =
            new JPanel(
                new GridLayout(
                    1,
                    4,
                    8,
                    0));


        firstDigitButton =
            new JButton("First Digit");

        firstDigitButton.addActionListener(
            event -> showFirstDigit());


        lastDigitButton =
            new JButton("Last Digit");

        lastDigitButton.addActionListener(
            event -> showLastDigit());


        sumButton =
            new JButton("Digit Sum");

        sumButton.addActionListener(
            event -> showDigitSum());


        giveUpButton =
            new JButton("Give Up");

        giveUpButton.addActionListener(
            event -> giveUp());


        hintPanel.add(firstDigitButton);
        hintPanel.add(lastDigitButton);
        hintPanel.add(sumButton);
        hintPanel.add(giveUpButton);


        // ---------------- STATUS ----------------

        statusLabel =
            new JLabel(
                "Enter your first guess.",
                SwingConstants.CENTER);

        statusLabel.setAlignmentX(
            JLabel.CENTER_ALIGNMENT);


        controls.add(guessPanel);

        controls.add(
            Box.createVerticalStrut(8));

        controls.add(hintPanel);

        controls.add(
            Box.createVerticalStrut(10));

        controls.add(statusLabel);


        window.add(
            controls,
            BorderLayout.SOUTH);


        // No hints until the player
        // makes an incorrect guess.
        setOptionButtonsEnabled(false);


        window.pack();

        window.setLocationRelativeTo(null);

        window.setVisible(true);
    }


    /**
     * Processes the player's guess.
     */
    private void submitGuess()
    {
        if (!playing)
        {
            return;
        }


        String input =
            guessField.getText().trim();


        // Check that the input is numeric.
        if (!validator.isInteger(input))
        {
            statusLabel.setText(
                "Invalid input. Enter digits only, "
                    + "such as 12345.");

            return;
        }


        // Check the game's five-digit rules.
        if (!validator.isValidGuess(input))
        {
            statusLabel.setText(
                "Invalid guess. Enter exactly five digits "
                    + "and do not start with 0.");

            return;
        }


        int guess =
            Integer.parseInt(input);

        guessField.setText("");


        // ---------------- WIN ----------------

        if (methods.isCorrect(
            guess,
            correctAnswer))
        {
            ArrayList<Integer> allCorrect =
                new ArrayList<Integer>(
                    Arrays.asList(
                        1,
                        2,
                        3,
                        4,
                        5));

            addGuessRow(
                input,
                allCorrect);

            statusLabel.setText(
                "You cracked the code! "
                    + "The answer was "
                    + correctAnswer
                    + ".");

            endGame();

            return;
        }


        // ---------------- WRONG GUESS ----------------

        ArrayList<Integer> correctPositions =
            methods.getCorrectPositions(
                guess,
                correctAnswer);


        addGuessRow(
            input,
            correctPositions);


        statusLabel.setText(
            "Green digits are in the correct position. "
                + "Guess again or use one option below.");


        setOptionButtonsEnabled(true);
    }


    /**
     * Adds one Wordle-style guess row.
     *
     * @param guessText
     *            the player's five-digit guess
     * @param correctPositions
     *            one-based positions that are correct
     */
    private void addGuessRow(
        String guessText,
        ArrayList<Integer> correctPositions)
    {
        JPanel row =
            new JPanel(
                new GridLayout(
                    1,
                    5,
                    8,
                    0));


        row.setMaximumSize(
            new Dimension(
                430,
                65));


        for (int i = 0; i < 5; i++)
        {
            JLabel box =
                createDigitBox(
                    String.valueOf(
                        guessText.charAt(i)));


            // getCorrectPositions()
            // is supposed to return
            // positions 1 through 5.
            if (correctPositions.contains(i + 1))
            {
                box.setBackground(
                    CORRECT_COLOR);
            }
            else
            {
                box.setBackground(
                    INCORRECT_COLOR);
            }


            box.setForeground(
                Color.WHITE);


            row.add(box);
        }


        historyPanel.add(row);

        historyPanel.add(
            Box.createVerticalStrut(8));


        historyPanel.revalidate();

        historyPanel.repaint();
    }


    /**
     * Creates one square digit box.
     *
     * @param text
     *            digit displayed in the box
     * @return formatted digit label
     */
    private JLabel createDigitBox(
        String text)
    {
        JLabel box =
            new JLabel(
                text,
                SwingConstants.CENTER);


        box.setOpaque(true);

        box.setPreferredSize(
            new Dimension(
                65,
                65));


        box.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                28));


        box.setBorder(
            BorderFactory.createLineBorder(
                Color.DARK_GRAY,
                2));


        return box;
    }


    /**
     * Shows the first-digit hint.
     */
    private void showFirstDigit()
    {
        statusLabel.setText(
            "Hint: the first digit is "
                + methods.getFirstDigit(
                    correctAnswer)
                + ".");


        setOptionButtonsEnabled(false);
    }


    /**
     * Shows the last-digit hint.
     */
    private void showLastDigit()
    {
        statusLabel.setText(
            "Hint: the last digit is "
                + methods.getLastDigit(
                    correctAnswer)
                + ".");


        setOptionButtonsEnabled(false);
    }


    /**
     * Shows the digit-sum hint.
     */
    private void showDigitSum()
    {
        statusLabel.setText(
            "Hint: the digits add up to "
                + methods.getDigitsSum(
                    correctAnswer)
                + ".");


        setOptionButtonsEnabled(false);
    }


    /**
     * Ends the game and reveals
     * the secret number.
     */
    private void giveUp()
    {
        statusLabel.setText(
            "Game over. The secret number was "
                + correctAnswer
                + ".");


        endGame();
    }


    /**
     * Enables or disables hint
     * and give-up buttons.
     *
     * @param enabled
     *            true to enable them
     */
    private void setOptionButtonsEnabled(
        boolean enabled)
    {
        firstDigitButton.setEnabled(
            enabled && playing);

        lastDigitButton.setEnabled(
            enabled && playing);

        sumButton.setEnabled(
            enabled && playing);

        giveUpButton.setEnabled(
            enabled && playing);
    }


    /**
     * Locks the interface once
     * the game has ended.
     */
    private void endGame()
    {
        playing = false;

        guessField.setEnabled(false);

        guessButton.setEnabled(false);

        setOptionButtonsEnabled(false);
    }


    /**
     * Starts the graphical game.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(
        String[] args)
    {
        SwingUtilities.invokeLater(
            GameGUI::new);
    }
}
