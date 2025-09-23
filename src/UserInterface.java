import java.util.Scanner;
public class UserInterface {
    private String[] stages;
    private String[] letters;
    public UserInterface(String[] stages, int wordNum) {
        this.stages=stages.clone();
        letters=new String[wordNum];
        for (int i=0;i<wordNum;i++) {
            letters[i]="_";
        }
    }
    public void setLetter(String letter, int pos) {
        letters[pos]=letter;
    }
    public void display(int stage) {
        System.out.println(stages[stage]);
        for (String letter : letters) {
            System.out.print(letter + " ");
        }
        System.out.print("\nRemaining letters: ");
        for (String letter : Data.getRemainingLetters()) {
            System.out.print(letter);
        }
        System.out.println();
        System.out.print("Typed letters: ");
        for (String letter: Data.getTypedLetters()) {
            System.out.print(letter);
        }
        System.out.print("\n: ");
    }
    public String userInput(Scanner readInput) {
        String input;
        do {
            input=readInput.nextLine();
            if (input.length()>1) {
                System.out.println("Please enter one character!");
                System.out.print(": ");
            }
        } while(input.length()>1);
        return input;
    }
}
