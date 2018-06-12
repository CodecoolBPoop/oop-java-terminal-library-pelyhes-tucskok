import java.util.*;

public class Interface {

    public void printScreen(char[] guessedWord, int missedGuesses) {
        for (char ch: guessedWord) {
            System.out.print(ch + " ");
        }
        System.out.println("\t" + String.valueOf(missedGuesses) + "/7\n");
    }

    public char getCharacter() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] inputArray = input.toCharArray();
        char inputChar = inputArray[0];
        return inputChar;
    }
}
