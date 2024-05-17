package utils;

public class Word {
    // class for storing words and a method to randomly select word

    // list of words
    private static final String[] words = {"elephant", "java", "coding", "cat", "dog"};

    // method to get random word
    public static String getRandomWord() {
        return words[(int) (Math.random() * words.length)];
    }
}
