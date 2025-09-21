import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Hangman {
    public static boolean loadWords(File file) {
        try(Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                Data.addWord(reader.nextLine());
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("An error occured reading the dictionary!");
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        File wordFile= new File("./src/words_alpha.txt");
        if(loadWords(wordFile)) {
            String word=Data.getRandWord();
            UserInterface UI = new UserInterface(Data.getStages(), word.length());
            String letter;
            int foundLetters=0;
            int currectStage=0;
            do {
                UI.display(currectStage);
                letter=UI.userInput();
                boolean exists=false;
                for (int i=0;i<word.length();i++) {
                    if (letter.equals(Character.toString(word.toLowerCase().charAt(i)))) {
                        exists=true;
                        UI.setLetter(letter, i);
                        foundLetters++;
                    }
                }
                if (!exists) {
                    currectStage++;
                }
                Data.removeLetter(letter);
            } while (Data.getStages().length>currectStage && word.length()>foundLetters);
            if (Data.getStages().length<=currectStage) {
                System.out.println("You lost! The word was " + word);
            } else {
                System.out.println("Congrats! You won!");
            }
        }

    }
}
