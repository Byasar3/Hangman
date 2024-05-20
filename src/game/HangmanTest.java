package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    private Hangman hangman;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        hangman = new Hangman();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("checking 'turnWordIntoUnderscores' function works")
    void turnWordIntoUnderscores_takesInWord_ReturnsCorrectly() {
        char[] result = hangman.turnWordIntoUnderscores("cat");
        char[] expected = {'_', ' ', '_', ' ', '_'};
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("checking game restarts")
    void restartGame_correctInputs_resetsGame() {
        hangman.restartGame("easy");
        assertEquals(Hangman.INITIAL_LIVES, hangman.lives);
        assertTrue(hangman.lettersGuessed.isEmpty());
        assertNotNull(hangman.wordToGuess);
        assertNotNull(hangman.wordToGuessUnderscore);
    }

    @Test
    @DisplayName("Checking if word is not guessed")
    void isWordGuessed_wordNotGuessed_returnsFalse() {
        hangman.wordToGuessUnderscore = new char[]{'c', 'a', '_'};
        assertFalse(hangman.isWordGuessed());
    }

    @Test
    @DisplayName("Checking if word is guessed")
    void isWordGuessed_wordGuessed_returnsTrue() {
        hangman.wordToGuessUnderscore = new char[]{'c', 'a', 't'};
        assertTrue(hangman.isWordGuessed());
    }

    @Test
    @DisplayName("Handling guess when letter is correct")
    void handleGuess_correctLetter_updatesWordToGuessUnderscore() {
        hangman.wordToGuess = "cat";
        hangman.wordToGuessUnderscore = new char[]{'c', ' ', '_', ' ', '_'};
        hangman.handleGuess('a');
        assertArrayEquals(new char[]{'c', ' ', 'a', ' ', '_'}, hangman.wordToGuessUnderscore);
    }

    @Test
    @DisplayName("Handling guess when letter is incorrect")
    void handleGuess_incorrectLetter_decreasesLivesAndNoUpdateToWord() {
        hangman.wordToGuess = "cat";
        hangman.lives = 3;
        hangman.handleGuess('b');
        assertEquals(2, hangman.lives);
        hangman.wordToGuessUnderscore = new char[]{'c', ' ', '_', ' ', '_'};
        hangman.handleGuess('b');
        assertArrayEquals(new char[]{'c', ' ', '_', ' ', '_'}, hangman.wordToGuessUnderscore);
    }

    @Test
    @DisplayName("Handling guess when letter is already guessed")
    void handleGuess_letterAlreadyGuessed_doesNotAddToLettersGuessed() {
        hangman.wordToGuess = "cat";
        hangman.lettersGuessed.add('a');
        hangman.wordToGuessUnderscore = new char[]{'c', ' ', '_', ' ', '_'};
        hangman.handleGuess('a');
        assertEquals(1, hangman.lettersGuessed.size());
        String expectedMessage = "You already guessed the letter 'a'";
        // cleaning up output string as getting error: difference only in line separators
        String actualOutput = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n");
        assertEquals(expectedMessage, actualOutput);
    }

    @Test
    @DisplayName("Handling guess when letter is not already guessed")
    void handleGuess_letterNotAlreadyGuessed_addsToLettersGuessed() {
        hangman.wordToGuess = "cat";
        hangman.wordToGuessUnderscore = new char[]{'c', ' ', '_', ' ', '_'};
        hangman.handleGuess('b');
        assertEquals(1, hangman.lettersGuessed.size());
        assertTrue(hangman.lettersGuessed.contains('b'));
    }

    @Test
    @DisplayName("Handling restart game with different difficulties")
    void restartGame_differentDifficulties_resetsGame() {
        hangman.restartGame("easy");
        assertEquals(Hangman.INITIAL_LIVES, hangman.lives);
        assertEquals(0, hangman.lettersGuessed.size());
        assertNotNull(hangman.wordToGuess);
        assertNotNull(hangman.wordToGuessUnderscore);

        hangman.restartGame("medium");
        assertEquals(Hangman.INITIAL_LIVES, hangman.lives);
        assertEquals(0, hangman.lettersGuessed.size());
        assertNotNull(hangman.wordToGuess);
        assertNotNull(hangman.wordToGuessUnderscore);

        hangman.restartGame("difficult");
        assertEquals(Hangman.INITIAL_LIVES, hangman.lives);
        assertEquals(0, hangman.lettersGuessed.size());
        assertNotNull(hangman.wordToGuess);
        assertNotNull(hangman.wordToGuessUnderscore);
    }
}