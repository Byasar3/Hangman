import java.util.Scanner;

public class ResultsDisplay {
    // class for displaying results
    public void displayGameStart() {
        Scanner newScannerObject = new Scanner(System.in);
        //click any key to start game
        System.out.println("Press the enter key to start the game!");
        newScannerObject.nextLine();
    }

    // get the randomised word and display it
    public void displayWord(char[] wordToGuessUnderscore){
        System.out.println(wordToGuessUnderscore);
    }

    // display the word with each letter guess
    // is this needed? could just update the word to guess underscore in hangman...

    // display lives left/hanging man
    public void displayLives(int lives) {
        System.out.println("You have " + lives + " lives left.");
    }
}
