import java.util.ArrayList;
import java.util.Scanner;

public class ResultsDisplay {

    public void displayRules() {
        System.out.println("\n                 WELCOME TO TERMINAL HANGMAN!\n");
        System.out.println("   RULES:\n");
        System.out.println("1. You can only guess one letter at a time, not a word.");
        System.out.println("2. Each wrong letter guess is one life lost.");
        System.out.println("3. The game will end when you're out of lives or the word is guessed.\n");
    }

    public void displayGameStart() {
        Scanner newScannerObject = new Scanner(System.in);
        displayRules();
        System.out.println("Press the enter key to start the game!");
        newScannerObject.nextLine();
    }


    // get the randomised word and display it
    public void displayWord(char[] wordToGuessUnderscore){
        System.out.println(wordToGuessUnderscore);
        System.out.println("\n");
    }

    public void displayListOfGuessedLetters(ArrayList<Character> lettersGuessed){
        StringBuilder guessedLettersAsString = new StringBuilder();
        for (int i = 0; i < lettersGuessed.size(); i++){
            guessedLettersAsString.append(lettersGuessed.get(i));
            if ( i < lettersGuessed.size() - 1 ){
                guessedLettersAsString.append(", ");
            }

        }
        System.out.println("You've guessed these letters so far : " + guessedLettersAsString + "\n");
    }

    // display lives left/hanging man
    public void displayLives(int lives) {
        System.out.println("You have " + lives + " lives left.");
        System.out.println("---------------------------------------------------\n");
    }

    public void displayWin(char[] wordToGuessUnderscore){
        System.out.println("\n");
        System.out.println(wordToGuessUnderscore);
        System.out.println("\nCongratulations, you successfully guessed the word!");
        System.out.println("\nPress 'P' to play again");
        // create some functionality to restart game
    }

    public void displayGameOver(){
        System.out.println("\nOh no! You've run out of lives! Better luck next time :(");
        System.out.println("\nPress 'P' to play again");
        // create some functionality to restart game
    }
}
