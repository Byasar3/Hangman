package game;

import utils.Word;

public class Medium extends Hangman{

    public Medium(String difficulty){
        this.wordToGuess = Word.getRandomWord(difficulty);
        this.wordToGuessUnderscore = turnWordIntoUnderscores(wordToGuess);
    }
}
