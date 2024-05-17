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
    private String wordToGuess;
    private char[] wordToGuessUnderscore;
    private int lives;
    private final ArrayList<Character> lettersGuessed;
    private final ResultsDisplay resultsDisplay;
    private final UserInteraction userInteraction;

    // constructor
    public Hangman() {
        this.wordToGuess = Word.getRandomWord();
        this.lives = INITIAL_LIVES; // hard coded number of lives
        this.lettersGuessed = new ArrayList<>();
        this.wordToGuessUnderscore = turnWordIntoUnderscores(wordToGuess);
        this.resultsDisplay = new ResultsDisplay();
        this.userInteraction = new UserInteraction();
    }

    // methods
    private char[] turnWordIntoUnderscores(String wordToGuess) {
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

    public void restartGame() {
        this.lives = INITIAL_LIVES;
        this.lettersGuessed.clear();
        this.wordToGuess = Word.getRandomWord();
        this.wordToGuessUnderscore = turnWordIntoUnderscores(this.wordToGuess);
    }


    public void playGame() {
        Scanner newScannerObject = new Scanner(System.in);

        while (true) {
            resultsDisplay.displayGameStart();

            while (lives > 0 && !isWordGuessed()) {
                resultsDisplay.displayWord(wordToGuessUnderscore);
                if (!lettersGuessed.isEmpty()) {
                    resultsDisplay.displayListOfGuessedLetters(lettersGuessed);
                }
                resultsDisplay.displayLives(lives);
                char guessedLetter = userInteraction.getUserGuess(newScannerObject);
                handleGuess(guessedLetter);
            }

            if (lives == 0 || isWordGuessed()) {
                resultsDisplay.displayEndOfGame(isWordGuessed());
                char restartChoice = userInteraction.getRestartChoice(newScannerObject);
                if (restartChoice == 'p' || restartChoice == 'P') {
                    restartGame();
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
