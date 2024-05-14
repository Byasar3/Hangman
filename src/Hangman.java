import java.util.Scanner;

public class Hangman {

    // states and behaviours of hangman game / blueprint to create instances with
    // each game is new instance
    String word;

    // class for connecting the other classes together and running the game

    public static void main(String[] args) {

        // i think this will go above main, and main will only call it/things it needs

        Scanner newScannerObject = new Scanner(System.in);

        //click any button to start game
        System.out.println("Press any key to start game!");
        String startGame = newScannerObject.nextLine();

        // needs to get word and display word
        System.out.println("working check: " + startGame);

        // then needs to ask for user input,
        // save that input into guessed letters array,
        // check if the guessed letter is in word, if so, say congrats, put in word and render filled in word
        // if not in word, say sorry not in word and -1 life
    }
}
