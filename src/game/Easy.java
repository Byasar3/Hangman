package game;

import utils.WordUtils;

public class Easy extends Hangman{
    public Easy (String difficulty){
        this.wordToGuess = WordUtils.getRandomWord(difficulty);
        this.wordToGuessUnderscore = turnWordIntoUnderscores(wordToGuess);
    }
}
