package utils;

public class WordUtils {
    // class for storing words and a method to randomly select word

    // list of words
    private static final String[] easyWords = {"cat", "dog", "bird", "sun", "hat", "run", "fish", "book", "tree", "cake", "lemon", "smile", "cloud", "flower"};
    private static final String[] mediumWords = {"java", "python", "table", "chair", "river", "phone", "guitar", "mountain", "rainbow", "library", "bicycle", "telescope", "adventure", "universe", "chocolate"};
    private static final String[] hardWords = {"hangman", "algorithm", "programming", "symphony", "pneumonia", "exquisite", "ophthalmology", "entrepreneur", "paradox", "serendipity", "rhythm", "phenomenon", "chrysanthemum", "connoisseur", "epistemology" };

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
