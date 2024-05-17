package game;

import utils.Word;

public class Easy extends Hangman{

    public Easy (String difficulty){
        this.wordToGuess = Word.getRandomWord(difficulty);
        this.wordToGuessUnderscore = turnWordIntoUnderscores(wordToGuess);
    }
}
