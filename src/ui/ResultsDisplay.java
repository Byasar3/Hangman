package ui;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.AnsiColourUtils.*;

public class ResultsDisplay {
    private static final Scanner SCANNER = new Scanner(System.in);

    public void displayRules() {
        System.out.println(colourise(
                " _                                             \n" +
                        "| |                                            \n" +
                        "| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  \n" +
                        "| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n" +
                        "| | | | (_| | | | | (_| | | | | | | (_| | | | |\n" +
                        "|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n" +
                        "                    __/ |                      \n" +
                        "                   |___/                       "
                , CYAN));
        System.out.println(colourise("\nWELCOME TO TERMINAL HANGMAN!\n", PURPLE));
        System.out.println(colourise("   RULES:\n", BLUE));
        System.out.println(colourise("1. You can only guess one letter at a time, not a word.", BLUE));
        System.out.println(colourise("2. Each wrong letter guess is one life lost.", BLUE));
        System.out.println(colourise("3. The game will end when you're out of lives or the word is guessed.\n", BLUE));
    }

    public void displayGameStart() {
        displayRules();
        System.out.println("Press the enter key to start the game!");
        SCANNER.nextLine();
    }

    public void displayDifficultySelection() {
        System.out.println("Choose difficulty level:");
        System.out.println(colourise("1. Easy", GREEN));
        System.out.println(colourise("2. Medium", YELLOW));
        System.out.println(colourise("3. Difficult", RED));
        System.out.print("Enter your choice (1, 2, or 3): \n");
    }

    public void displayWord(char[] wordToGuessUnderscore) {
        System.out.println("\n");
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
        System.out.println(colourise("You've guessed these letters so far : " + guessedLettersAsString + "\n", CYAN));
    }

    public void displayLives(int lives) {
        if (lives <= 10 && lives >= 7) {
            System.out.println(colourise("You have " + lives + " lives left.", GREEN));
        } else if (lives <= 6 && lives >= 4) {
            System.out.println(colourise("You have " + lives + " lives left.", YELLOW));
        } else {
            System.out.println(colourise("You have " + lives + " lives left.", RED));

        }
        switch (lives) {
            case 9:
                System.out.println(
                        "            \n" +
                                "            \n" +
                                "            \n" +
                                "            \n" +
                                "            \n" +
                                "            \n" +
                                "     ========="
                );
                break;
            case 8:
                System.out.println(
                        "           +\n" +
                                "           |\n" +
                                "           |\n" +
                                "           |\n" +
                                "           |\n" +
                                "           |\n" +
                                "     ========="
                );
                break;

            case 7:
                System.out.println(
                        "       +---+\n" +
                                "           |\n" +
                                "           |\n" +
                                "           |\n" +
                                "           |\n" +
                                "           |\n" +
                                "     ========="
                );
                break;
            case 6:
                System.out.println(
                        "       +---+\n" +
                                "       |   |\n" +
                                "           |\n" +
                                "           |\n" +
                                "           |\n" +
                                "           |\n" +
                                "     ========="
                );
                break;
            case 5:
                System.out.println(
                        "       +---+\n" +
                                "       |   |\n" +
                                "       O   |\n" +
                                "           |\n" +
                                "           |\n" +
                                "           |\n" +
                                "     ========="
                );
                break;
            case 4:
                System.out.println(
                        "       +---+\n" +
                                "       |   |\n" +
                                "       O   |\n" +
                                "       |   |\n" +
                                "           |\n" +
                                "           |\n" +
                                "     ========="
                );
                break;
            case 3:
                System.out.println(
                        "       +---+\n" +
                                "       |   |\n" +
                                "       O   |\n" +
                                "      /|   |\n" +
                                "           |\n" +
                                "           |\n" +
                                "     ========="
                );
                break;
            case 2:
                System.out.println(
                        "       +---+\n" +
                                "       |   |\n" +
                                "       O   |\n" +
                                "      /|\\  |\n" +
                                "           |\n" +
                                "           |\n" +
                                "     ========="
                );
                break;
            case 1:
                System.out.println(
                        "       +---+\n" +
                                "       |   |\n" +
                                "       O   |\n" +
                                "      /|\\  |\n" +
                                "      /    |\n" +
                                "           |\n" +
                                "     ========="
                );
                break;
            case 0:
                System.out.println(
                        "       +---+\n" +
                                "       |   |\n" +
                                "       O   |\n" +
                                "      /|\\  |\n" +
                                "      / \\  |\n" +
                                "           |\n" +
                                "     ========="
                );
                break;
            default:
        }
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public void displayEndOfGame(boolean isWordGuessed, String wordToGuess) {
        if (isWordGuessed) {
            System.out.println(colourise("\nCongratulations! you successfully guessed the word: " + wordToGuess, GREEN));
        } else {
            displayLives(0);
            System.out.println(colourise("\nThe word was: " + wordToGuess + "\nBetter luck next time :(", RED));
        }
    }

}
