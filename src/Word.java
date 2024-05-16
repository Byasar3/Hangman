public class Word {
    // class for storing words and a method to randomly select word

    // list of words
    private final String[] words = {"elephant", "java", "coding", "cat", "dog"};

    // constructor
    public Word() {
        String currentWord = getRandomWord(); // will get word from get random word method
    }

    // method to get random word
    public String getRandomWord() {
        return words[(int) (Math.random() * words.length)];
    }
}
