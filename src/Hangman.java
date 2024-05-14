import java.util.Scanner;
// class for connecting the other classes together and running the game
public class Hangman {

    // states and behaviours of hangman game / blueprint to create instances with
    protected Word word;
    protected String wordToGuess;
    protected int lives;
    protected char[] lettersGuessed;

    // constructor
    public Hangman() {
        this.word = new Word();
        this.wordToGuess = word.getRandomWord();
        this.lives = 10; // hard coded number of lives
    }

    // getters and setters
    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public char[] getLettersGuessed() {
        return lettersGuessed;
    }

    public void setLettersGuessed(char[] lettersGuessed) {
        this.lettersGuessed = lettersGuessed;
    }

    // methods
    public void startGame () {
        Scanner newScannerObject = new Scanner(System.in);
        //click any key to start game
        System.out.println("Press the enter key to start the game!");
        newScannerObject.nextLine();

        System.out.println(wordToGuess);
    }

    // needs to get word and display word
    // then needs to ask for user input,
    // save that input into guessed letters array,
    // check if the guessed letter is in word, if so, say congrats, put in word and render filled in word
    // if not in word, say sorry not in word and -1 life


    public static void main(String[] args) {
    // create an instance of hangman and run startgame method on it
    Hangman game = new Hangman();
    game.startGame();
    }
}
