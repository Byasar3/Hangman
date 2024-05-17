package main;
import gameLogic.Hangman;

public class Main {
    public static void main(String[] args) {
        // create an instance of hangman and run playGame() on it
        Hangman game = new Hangman();
        game.playGame();
    }
}
