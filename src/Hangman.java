import java.util.Scanner;
// class for connecting the other classes together and running the game
public class Hangman {

    // states and behaviours of hangman game / blueprint to create instances with
    protected Word word;
    protected String wordToGuess;
    protected char[] wordToGuessUnderscore;
    protected int lives;
    protected char[] lettersGuessed;
    protected ResultsDisplay resultsDisplay;
    protected UserInteraction userInteraction;


    // constructor
    public Hangman() {
        this.word = new Word();
        this.wordToGuess = word.getRandomWord();
        this.lives = 10; // hard coded number of lives
        this.wordToGuessUnderscore = turnWordIntoUnderscores(wordToGuess);
        this.resultsDisplay = new ResultsDisplay();
        this.userInteraction =  new UserInteraction();
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

    public void playGame() {
            resultsDisplay.displayGameStart();
            resultsDisplay.displayWord(wordToGuessUnderscore);
            resultsDisplay.displayLives(lives);
            Scanner newScannerObject = new Scanner(System.in);
            char guessedLetter = userInteraction.getUserGuess(newScannerObject);
            handleGuess(guessedLetter);
    }

    public void handleGuess(char guessedLetter) {
        System.out.println("this be here: " + guessedLetter);
        // check if letter already been guessed
        //
    }



    // save that input into guessed letters array,
    // check if the guessed letter is in word, if so, say congrats, put in word and render filled in word
    // if not in word, say sorry not in word and -1 life


    public static void main(String[] args) {
    // create an instance of hangman and run playgame method on it
    Hangman game = new Hangman();
    game.playGame();
    }
}
