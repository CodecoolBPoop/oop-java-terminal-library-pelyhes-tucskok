import java.util.*;

public class Game {

    private static String word = "fing";

    public boolean wordIsCompleted(char[] guessedWord) {
        for (char ch: guessedWord) {
            if (ch == '_') {
                return false;
            }
        }
        return true;
    }

    public void printScreen(char[] guessedWord, int missedGuesses) {
        for (char ch: guessedWord) {
            System.out.print(ch + " ");
        }
        System.out.println("\t" + String.valueOf(missedGuesses) + "/7");
        System.out.println();
    }

    public void startGame() {

        char[] wordArray = word.toCharArray();
        char[] guessedWord = new char[wordArray.length];
        Scanner scanner = new Scanner(System.in);
        String input = new String();

        for (int i = 0; i < guessedWord.length; i++) {
          guessedWord[i] = '_';
        }

        int missedGuesses = 0;
        while (missedGuesses <= 7) {
            printScreen(guessedWord, missedGuesses);

            input = scanner.nextLine();
            char[] inputArray = input.toCharArray();
            char inputChar = inputArray[0];

            if (word.indexOf(inputChar) != -1) {
                for (int i = 0; i < wordArray.length; i++) {
                  if (wordArray[i] == inputChar) {
                    guessedWord[i] = inputChar;
                  }
                }
            } else {
              missedGuesses++;
            }

            if (wordIsCompleted(guessedWord)) {
              break;
            }
        }

        if (wordIsCompleted(guessedWord)) {
            System.out.println("You won!");
        } else {
            System.out.println("You lose!");
        }

    }
}
