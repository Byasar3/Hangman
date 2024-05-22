package game;

import utils.WordUtils;

public class Difficult extends Hangman {
    public Difficult (String difficulty){
        this.wordToGuess = WordUtils.getRandomWord(difficulty);
        this.wordToGuessUnderscore = turnWordIntoUnderscores(wordToGuess);
    }
}
