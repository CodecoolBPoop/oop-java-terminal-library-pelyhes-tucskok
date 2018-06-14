package com.codecool.hangman;

import com.codecool.termlib.*;
import java.util.*;
import java.io.*;

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
    
    public int calculateFinalScore(int missedGuesses) {
	int finalScore = (7 - missedGuesses) * 100;
	return finalScore;	
	}

    public void startGame() {
	FileHandler handleFile = new FileHandler();
        Interface inter = new Interface();
	Terminal terminal = new Terminal();
	terminal.setColor(Color.BLACK);
	terminal.setBgColor(Color.WHITE);
	terminal.clearScreen();
	ArrayList<String> missedLetters = new ArrayList<String>();
        char[] wordArray = word.toCharArray();
        char[] guessedWord = new char[wordArray.length];

        for (int i = 0; i < guessedWord.length; i++) {
          guessedWord[i] = '_';
        }
	 

        int missedGuesses = 0;
        while (missedGuesses < 7) {
	    terminal.clearScreen();
            inter.printScreen(guessedWord, missedGuesses, missedLetters);
            char inputChar = inter.getCharacter();
		
		
            if (word.indexOf(inputChar) != -1) {
		if (new String(guessedWord).indexOf(inputChar) != -1) {
		    inter.printMessage("Already exists");
		}
                putCharToGuessedWord(wordArray, guessedWord, inputChar);
            }
	    else {
		String inputString = String.valueOf(inputChar);
		if(missedLetters.indexOf(inputString) != -1){
                	inter.printMessage("Already exists");
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
            inter.printMessage("You won!");
	    
	    String name = inter.getName();
	    String readFile = handleFile.getHighScoreFromFile();
  	    handleFile.writeHighScoreToFile(readFile, name, calculateFinalScore(missedGuesses));
        } 
	else {
	    inter.printGallows7();
            inter.printMessage("You lose!");
	    inter.printHighScore();
        }
	inter.printMessage("Your final score is " + calculateFinalScore(missedGuesses));
    }
}
