import java.util.Arrays;
import java.util.ArrayList;
public class Data {
    private static final String[] stages = {
            """
          +---+
          |   |
              |
              |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
              |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
          |   |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
         /|   |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
         /|\\  |
              |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
         /|\\  |
         /    |
              |
        =========
        """,
            """
          +---+
          |   |
          O   |
         /|\\  |
         / \\  |
              |
        =========
        """
    };
    private static ArrayList<String> alphabet=new ArrayList<String>(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));
    private static ArrayList<String> alphabetInput = new ArrayList<String>();
    private static ArrayList<String> words=new ArrayList<String>();
    public static void addWord(String word) {
        words.add(word);
    }
    public static String getRandWord() {
        return words.get((int)(Math.random()*words.size()));
    }
    public static String[] getStages() {
        return stages;
    }
    public static String[] getRemainingLetters() {
        String[] remLetters=new String[alphabet.size()];
        for (int i=0;i<alphabet.size();i++) {
            remLetters[i]=alphabet.get(i);
        }
        return remLetters;
    }
    public static String[] getTypedLetters() {
        String[] typedLetters = new String[alphabetInput.size()];
        for (int i=0;i< alphabetInput.size();i++) {
            typedLetters[i]=alphabetInput.get(i);
        }
        return typedLetters;
    }
    public static void setTypedLetter(String letter) {
        alphabetInput.add(letter);
    }
    public static void removeLetter(String letter) {
        alphabet.remove(letter);
    }
}
