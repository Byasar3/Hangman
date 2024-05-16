import java.util.Scanner;

public class ResultsDisplay {
    // class for displaying results
    public void displayGameStart() {
        Scanner newScannerObject = new Scanner(System.in);
        //click any key to start game
        displayRules();
        System.out.println("Press the enter key to start the game!");
        newScannerObject.nextLine();
    }

    // maybe include rules here = not allowed to guess word, only allowed to guess char
    public void displayRules() {
        System.out.println("   RULES:  ");
        System.out.println("1. You can only guess one letter at a time, not a word.");
        System.out.println("2. Each wrong letter guess is one life lost.");
        System.out.println("3. The game will end when you're out of lives or the word is guessed.");
    }

    // get the randomised word and display it
    public void displayWord(char[] wordToGuessUnderscore){
        System.out.println(wordToGuessUnderscore);
    }

    // display lives left/hanging man
    public void displayLives(int lives) {
        System.out.println("You have " + lives + " lives left.");
    }
}
