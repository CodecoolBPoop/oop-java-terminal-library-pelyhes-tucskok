import java.util.*;

public class Game {

    private static String word;

    Game(String word) {
        this.word = word;
    }

    public boolean wordIsCompleted(char[] guessedWord) {
        for (char ch: guessedWord) {
            if (ch == '_') {
                return false;
            }
        }
        return true;
    }

    public void putCharToGuessedWord(char[] wordArray, char[] guessedWord, char inputChar) {
        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i] == inputChar) {
              guessedWord[i] = inputChar;
            }
        }
    }

    public void startGame() {
        Interface inter = new Interface();

        char[] wordArray = word.toCharArray();
        char[] guessedWord = new char[wordArray.length];
        for (int i = 0; i < guessedWord.length; i++) {
          guessedWord[i] = '_';
        }

        int missedGuesses = 0;
        while (missedGuesses <= 7) {

            inter.printScreen(guessedWord, missedGuesses);
            char inputChar = inter.getCharacter();

            if (word.indexOf(inputChar) != -1) {
                putCharToGuessedWord(wordArray, guessedWord, inputChar);
            } else {
                missedGuesses++;
            }

            if (wordIsCompleted(guessedWord)) {
                break;
            }
        }

        if (wordIsCompleted(guessedWord)) {
            inter.printScreen(guessedWord, missedGuesses);
            System.out.println("You won!");
        } else {
            System.out.println("You lose!");
        }

    }
}
