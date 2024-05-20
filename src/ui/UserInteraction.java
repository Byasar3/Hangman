package ui;

import java.util.Scanner;

public class UserInteraction {

    public String getDifficultySelection(Scanner newScannerObject){
        int chosenDifficulty = newScannerObject.nextInt();
        while (true) {
            switch (chosenDifficulty){
                case 1:
                    return "easy";
                case 2:
                    return "medium";
                case 3:
                    return "difficult";
                default:
                    System.out.println("Invalid choice. Please pick either 1, 2 or 3.");
            }
        }
    }

    public char getUserGuess(Scanner newScannerObject) {
        // initialize to null character
        char firstChar = '\0';
        boolean isValidInput = false;

        // keep loop running until there is a valid input
        while (!isValidInput) {
            System.out.println("Guess a letter! ");
            String input = newScannerObject.nextLine();
            if (!input.isEmpty()) {
                firstChar = input.charAt(0);
                if (Character.isLetter(firstChar)) {
                    System.out.println("\nYou guessed letter: " + firstChar);
                    isValidInput = true;
                } else {
                    System.out.println("\nInvalid input. Please enter a letter");
                    // reset firstChar to null
                    firstChar = '\0';
                }
            } else {
                System.out.println("\nNo character entered.");
            }
        }
        return Character.toLowerCase(firstChar);
    }

    public char getRestartChoice(Scanner newScannerObject) {
        System.out.println("\nEnter 'P' to play again or 'Q' to quit game");
        return newScannerObject.nextLine().charAt(0);
    }
}
