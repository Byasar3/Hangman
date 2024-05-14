public class Word {
    // class for storing words and a method to randomly select word

    // list of words
    private String[] words = {"elephant", "java", "coding", "cat", "dog"};
    private String currentWord;

    // constructor
    public Word(){
        this.currentWord = getRandomWord(); // will get word from get random word method
    }

    // getters and setters
    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    // method to get random word
    public String getRandomWord () {
        return words[(int)(Math.random() * words.length)];
    }

    // turn word into underscores - here? or in Hangman class?
}
