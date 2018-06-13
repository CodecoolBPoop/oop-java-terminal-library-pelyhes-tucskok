package com.codecool.hangman;

import com.codecool.termlib.*;
import java.util.*;

public class Game {

    private static String word;

    Game(String word) {
        this.word = word.toUpperCase();
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
	Terminal terminal = new Terminal();
	terminal.clearScreen();

	ArrayList<String> missedLetters = new ArrayList<String>();
        char[] wordArray = word.toCharArray();
        char[] guessedWord = new char[wordArray.length];
        for (int i = 0; i < guessedWord.length; i++) {
          guessedWord[i] = '_';
        }

        int missedGuesses = 0;
        while (missedGuesses < 7) {

            inter.printScreen(guessedWord, missedGuesses, missedLetters);
            char inputChar = inter.getCharacter();

            if (word.indexOf(inputChar) != -1) {
                putCharToGuessedWord(wordArray, guessedWord, inputChar);
            } else {
		String inputString = String.valueOf(inputChar);
		if(missedLetters.indexOf(inputString) != -1){
                	inter.printAlertMessage("Already exists");
		}else{
			missedLetters.add(inputString);
			missedGuesses++;
}
            }

            if (wordIsCompleted(guessedWord)) {
                break;
            }
        }

        if (wordIsCompleted(guessedWord)) {
            inter.printScreen(guessedWord, missedGuesses, missedLetters);
            System.out.println("You won!");
        } else {
            System.out.println("You lose!");
        }

    }
}
