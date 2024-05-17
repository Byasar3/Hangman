package utils;

public class Word {
    // class for storing words and a method to randomly select word

    // list of words
    private static final String[] easyWords = {"cat", "dog", "bird"};
    private static final String[] mediumWords = {"java", "python", "ruby"};
    private static final String[] hardWords = {"hangman", "algorithm", "programming"};

    // method to get random word
    public static String getRandomWord(String difficulty) {
        switch (difficulty.toLowerCase()){
            case "easy":
                return easyWords[(int) (Math.random() * easyWords.length)];
            case "medium":
                return mediumWords[(int) (Math.random() * mediumWords.length)];
            case "difficult":
                return hardWords[(int) (Math.random() * hardWords.length)];
            default:
                throw new Error("invalid difficulty level");
        }
    }
}
