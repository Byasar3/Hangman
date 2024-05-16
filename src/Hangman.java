import java.util.ArrayList;
import java.util.Scanner;

// class for connecting the other classes together and running the game
public class Hangman {

    // states
    protected Word word;
    protected String wordToGuess;
    protected char[] wordToGuessUnderscore;
    protected int lives;
    protected ArrayList<Character> lettersGuessed;
    protected ResultsDisplay resultsDisplay;
    protected UserInteraction userInteraction;


    // constructor
    public Hangman() {
        this.word = new Word();
        this.wordToGuess = word.getRandomWord();
        this.lives = 10; // hard coded number of lives
        this.lettersGuessed = new ArrayList<>();
        this.wordToGuessUnderscore = turnWordIntoUnderscores(wordToGuess);
        this.resultsDisplay = new ResultsDisplay();
        this.userInteraction = new UserInteraction();
    }

    // methods
    public char[] turnWordIntoUnderscores(String wordToGuess) {
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

    public void playGame() {
        resultsDisplay.displayGameStart();
        while (lives > 0 && !isWordGuessed()) {
            resultsDisplay.displayWord(wordToGuessUnderscore);
            if (!lettersGuessed.isEmpty()) {
                resultsDisplay.displayListOfGuessedLetters(lettersGuessed);
            }
            resultsDisplay.displayLives(lives);
            Scanner newScannerObject = new Scanner(System.in);
            char guessedLetter = userInteraction.getUserGuess(newScannerObject);
            handleGuess(guessedLetter);
        }
        if (lives == 0) {
            resultsDisplay.displayGameOver();
        }
        if (isWordGuessed()) {
            resultsDisplay.displayWin(wordToGuessUnderscore);
        }
    }

    public static void main(String[] args) {
        // create an instance of hangman and run playGame() on it
        Hangman game = new Hangman();
        game.playGame();
    }
}
