package game;

import utils.WordUtils;

public class Medium extends Hangman{
    public Medium(String difficulty){
        this.wordToGuess = WordUtils.getRandomWord(difficulty);
        this.wordToGuessUnderscore = turnWordIntoUnderscores(wordToGuess);
    }
}
