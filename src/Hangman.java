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
        File wordFile= new File("/home/jimchrist-x/Documents/java-programming/hangman/src/words_alpha.txt");
        if(loadWords(wordFile)) {
            String word=Data.getRandWord();
            UserInterface UI = new UserInterface(Data.getStages(), word.length());
            Scanner readInput=new Scanner(System.in);
            String letter;
            int foundLetters=0;
            int currentStage=0;
            do {
                UI.display(currentStage);
                letter=UI.userInput(readInput);
                boolean exists=false;
                boolean alreadyTyped=false;
                for (String typed : Data.getTypedLetters()) {
                    if(typed.equals(letter.toLowerCase())) {
                        alreadyTyped=true;
                        break;
                    }
                }
                if (!alreadyTyped) {
                    for (int i=0;i<word.length();i++) {
                        if (letter.toLowerCase().equals(Character.toString(word.toLowerCase().charAt(i)))) {
                            exists=true;
                            UI.setLetter(letter.toLowerCase(), i);
                            foundLetters++;
                        }
                    }
                    if (!exists) {
                        currentStage++;
                    }
                    Data.setTypedLetter(letter.toLowerCase());
                    Data.removeLetter(letter.toLowerCase());
                }
            } while (Data.getStages().length>currentStage && word.length()>foundLetters);
            if (Data.getStages().length<=currentStage) {
                System.out.println("You lost! The word was " + word);
            } else {
                System.out.println("Congrats! You won!");
            }
        }

    }
}
