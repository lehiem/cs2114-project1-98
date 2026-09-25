# cs2114-project1-98
# Crack the Code

Crack the Code is a five-digit number guessing game created for CS 2114 Project 1.

The program generates a random five-digit number and asks the player to guess it. After an incorrect guess, the player receives feedback about which digits are in the correct positions and can choose to guess again, request a hint, or give up.

## Features

- Five-digit number guessing
- Input validation for invalid guesses
- Wordle-inspired graphical interface
- Green tiles for digits in the correct position
- Red tiles for incorrect positions
- Guess history
- First-digit hint
- Last-digit hint
- Sum-of-digits hint
- Give-up option
- JUnit tests for game logic and input validation

## How to Run

1. Clone or download this repository.
2. Import the project into Eclipse.
3. Make sure the CS2 Support library is available in Eclipse.
4. Open `src/GameGUI.java`.
5. Right-click `GameGUI.java`.
6. Select **Run As → Java Application**.

The original console version can also be launched by running `Game.java`.

## How to Run the Tests

In Eclipse, right-click a test class and select:

**Run As → JUnit Test**

Test classes include:

- `GameMethodsTest.java`
- `GameTest.java`
- `InputValidatorTest.java`

## Project Structure

- `GameGUI.java` — graphical user interface
- `Game.java` — console version and overall game flow
- `GameMethods.java` — game calculations and hint logic
- `InputValidator.java` — validates guesses and menu options
- `GameMethodsTest.java` — tests for game logic
- `GameTest.java` — tests for game flow
- `InputValidatorTest.java` — tests for input validation

## System Diagram

![System Diagram] <img width="764" height="760" alt="image" src="https://github.com/user-attachments/assets/fae5c415-eef7-4cca-88f9-081658547855" />


## Stretch Goal

Our original stretch goal was allowing the user to choose the length of the secret number. After feedback, we changed the stretch goal to a graphical interface.

The final GUI uses a Wordle-inspired layout to visually show which guessed digits are in the correct position.
