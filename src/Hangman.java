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
        // Create a StringBuilder to build the underscores with spaces
        StringBuilder underscoredWord = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            underscoredWord.append("_ ");
        }
        // Convert the StringBuilder to a char array
        return underscoredWord.toString().trim().toCharArray();
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
            System.out.println("You already guessed the letter " +  "'" + guessedLetter + "'");
            isCorrectGuess = true;
        }

        // check if letter in word, if is replace _ with letter
        for (int i = 0; i < wordToGuess.length(); i++){
            if (wordToGuess.charAt(i) == guessedLetter){
                if ( i == 0 ){
                    wordToGuessUnderscore[i] = guessedLetter;
                } else if ( i == 1 ){
                    wordToGuessUnderscore[i + 1] = guessedLetter;
                } else {
                    wordToGuessUnderscore[i * 2] = guessedLetter;
                }
                isCorrectGuess = true;
            }
        }

        if (!isCorrectGuess) {
            --lives;
        }

    }

    // check if the guessed letter is in word, if so, say congrats,
    // put in word and render filled in word
    // if not in word, say sorry not in word and -1 life

    public void playGame() {
        resultsDisplay.displayGameStart();
        while (lives > 0 && !isWordGuessed()) {
            resultsDisplay.displayWord(wordToGuessUnderscore);
            resultsDisplay.displayLives(lives);
            Scanner newScannerObject = new Scanner(System.in);
            char guessedLetter = userInteraction.getUserGuess(newScannerObject);
            handleGuess(guessedLetter);
        }
    }

    public static void main(String[] args) {
        // create an instance of hangman and run playgame method on it
        Hangman game = new Hangman();
        game.playGame();
    }
}
