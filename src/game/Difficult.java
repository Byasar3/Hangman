package game;

import utils.Word;

public class Difficult extends Hangman {
    public Difficult (String difficulty){
        this.wordToGuess = Word.getRandomWord(difficulty);
        this.wordToGuessUnderscore = turnWordIntoUnderscores(wordToGuess);

    }
}
