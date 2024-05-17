package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class ResultsDisplay {
    private static final Scanner SCANNER = new Scanner(System.in);

    public void displayRules() {
        System.out.println(
                " _                                             \n" +
                        "| |                                            \n" +
                        "| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  \n" +
                        "| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n" +
                        "| | | | (_| | | | | (_| | | | | | | (_| | | | |\n" +
                        "|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n" +
                        "                    __/ |                      \n" +
                        "                   |___/                       "
        );
        System.out.println("\nWELCOME TO TERMINAL HANGMAN!\n");
        System.out.println("   RULES:\n");
        System.out.println("1. You can only guess one letter at a time, not a word.");
        System.out.println("2. Each wrong letter guess is one life lost.");
        System.out.println("3. The game will end when you're out of lives or the word is guessed.\n");
    }

    public void displayGameStart() {
        displayRules();
        System.out.println("Press the enter key to start the game!");
        SCANNER.nextLine();
    }

    // get the randomised word and display it
    public void displayWord(char[] wordToGuessUnderscore) {
        System.out.println(wordToGuessUnderscore);
        System.out.println("\n");
    }

    public void displayListOfGuessedLetters(ArrayList<Character> lettersGuessed) {
        StringBuilder guessedLettersAsString = new StringBuilder();
        for (int i = 0; i < lettersGuessed.size(); i++) {
            guessedLettersAsString.append(lettersGuessed.get(i));
            if (i < lettersGuessed.size() - 1) {
                guessedLettersAsString.append(", ");
            }
        }
        System.out.println("You've guessed these letters so far : " + guessedLettersAsString + "\n");
    }

    // display lives left/hanging man
    public void displayLives(int lives) {
        System.out.println("You have " + lives + " lives left.");
        switch (lives){
            case 9:
                System.out.println(
                                "       \n" +
                                "       \n" +
                                "       \n" +
                                "       \n" +
                                "       \n" +
                                "       \n" +
                                "========="
                );
                break;
            case 8:
                System.out.println(
                                "      +\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "========="
                );
                break;

            case 7:
                System.out.println(
                                "  +---+\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "========="
                );
                break;
            case 6:
                System.out.println(
                                "  +---+\n" +
                                "  |   |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "========="
                );
                break;
            case 5:
                System.out.println(
                                "  +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "========="
                );
                break;
            case 4:
                System.out.println(
                                "  +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                "  |   |\n" +
                                "      |\n" +
                                "      |\n" +
                                "========="
                );
                break;
            case 3:
                System.out.println(
                                "  +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                " /|   |\n" +
                                "      |\n" +
                                "      |\n" +
                                "========="
                );
                break;
            case 2:
                System.out.println(
                                "  +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                " /|\\  |\n" +
                                "      |\n" +
                                "      |\n" +
                                "========="
                );
                break;
            case 1:
                System.out.println(
                                "  +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                " /|\\  |\n" +
                                " /    |\n" +
                                "      |\n" +
                                "========="
                );
                break;
            case 0:
                System.out.println(
                                "  +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                " /|\\  |\n" +
                                " / \\  |\n" +
                                "      |\n" +
                                "========="
                );
                break;
            default:
        }
        System.out.println("---------------------------------------------------\n");
    }

    public void displayEndOfGame(boolean isWordGuessed) {
        if (isWordGuessed) {
            System.out.println("\nCongratulations, you successfully guessed the word!");
        } else {
            displayLives(0);
            System.out.println("\nBetter luck next time :(");
        }
    }

}
