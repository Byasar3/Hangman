package game;

import java.util.ArrayList;
import java.util.Scanner;
import ui.ResultsDisplay;
import ui.UserInteraction;
import utils.Word;


// class for connecting the other classes together and running the game
public class Hangman {
    // constants
    private static final int INITIAL_LIVES = 10;

    // variables
    protected String wordToGuess;
    protected char[] wordToGuessUnderscore;
    private int lives;
    private ArrayList<Character> lettersGuessed;
    private ResultsDisplay resultsDisplay;
    private UserInteraction userInteraction;

    // constructor
    public Hangman() {
        this.lives = INITIAL_LIVES;
        this.lettersGuessed = new ArrayList<>();
        this.resultsDisplay = new ResultsDisplay();
        this.userInteraction = new UserInteraction();
    }


    // methods
    protected char[] turnWordIntoUnderscores(String wordToGuess) {
        // repeat "_ " as many times as the length of wordToGuess
        // trim any white space before or after
        // convert to character array
        return "_ ".repeat(wordToGuess.length()).trim().toCharArray();
    }

    public boolean isWordGuessed() {
        for (char c : wordToGuessUnderscore) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public void handleGuess(char guessedLetter) {
        boolean isCorrectGuess = false;
        // check if letter already been guessed
        if (!lettersGuessed.contains(guessedLetter)) {
            lettersGuessed.add(guessedLetter);
        } else {
            System.out.println("You already guessed the letter " + "'" + guessedLetter + "'");
            isCorrectGuess = true;
        }

        // check if letter in word, if it is, replace '_' with letter
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guessedLetter) {
                if (i == 0) {
                    wordToGuessUnderscore[i] = guessedLetter;
                } else if (i == 1) {
                    wordToGuessUnderscore[i + 1] = guessedLetter;
                } else {
                    wordToGuessUnderscore[i * 2] = guessedLetter;
                }
                isCorrectGuess = true;
            }
        }

        if (!isCorrectGuess) {
            --lives;
            if (lives > 0) {
                System.out.println("Sorry! Incorrect guess, try again.");
            } else {
                System.out.println("You used your final life...");
            }
        }
    }

    public void restartGame(String difficulty) {
        this.lives = INITIAL_LIVES;
        this.lettersGuessed.clear();
        this.wordToGuess = Word.getRandomWord(difficulty);
        this.wordToGuessUnderscore = turnWordIntoUnderscores(this.wordToGuess);
    }


    public void playGame() {
        Scanner newScannerObject = new Scanner(System.in);

        while (true) {
            resultsDisplay.displayGameStart();
            resultsDisplay.displayDifficultySelection();
            String difficulty = userInteraction.getDifficultySelection(newScannerObject);

            // Instantiate the appropriate subclass based on the difficulty chosen
            Hangman game;
            switch (difficulty.toLowerCase()) {
                case "easy":
                    game = new Easy(difficulty);
                    break;
                case "medium":
                    game = new Medium(difficulty);
                    break;
                case "difficult":
                    game = new Difficult(difficulty);
                    break;
                default:
                    System.out.println("Invalid difficulty level. Please pick either Easy, Medium, or Difficult.");
                    continue;
            }

            while (game.lives > 0 && !game.isWordGuessed()) {
                resultsDisplay.displayWord(game.wordToGuessUnderscore);
                if (!game.lettersGuessed.isEmpty()) {
                    resultsDisplay.displayListOfGuessedLetters(game.lettersGuessed);
                }
                resultsDisplay.displayLives(game.lives);
                char guessedLetter = userInteraction.getUserGuess(newScannerObject);
                game.handleGuess(guessedLetter);
            }

            if (game.lives == 0 || game.isWordGuessed()) {
                resultsDisplay.displayEndOfGame(game.isWordGuessed());
                char restartChoice = userInteraction.getRestartChoice(newScannerObject);
                if (restartChoice == 'p' || restartChoice == 'P') {
                    game.restartGame(difficulty);
                } else if ((restartChoice == 'q' || restartChoice == 'Q')) {
                    System.out.println("Exiting the game. Goodbye!");
                    break;
                } else {
                    System.out.println("Please enter a valid letter.");

                }
            }
        }
        newScannerObject.close();
    }
}
