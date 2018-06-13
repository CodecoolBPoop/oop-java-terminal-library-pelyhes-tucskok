package com.codecool.hangman;

import java.util.*;

public class Interface {

    public void printScreen(char[] guessedWord, int missedGuesses, ArrayList<String> missedLetters) {
        for (char ch: guessedWord) {
            System.out.print(ch + " ");
        }
        System.out.println("\t" + String.valueOf(missedGuesses) + "/7\n");
	System.out.println(Arrays.deepToString(missedLetters.toArray()));
    }

    public char getCharacter() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] inputArray = input.toCharArray();
        char inputChar = inputArray[0];
	char upperCaseChar = Character.toUpperCase(inputChar);
        return upperCaseChar;
    }


   public void printAlertMessage(String alert) {
	System.out.println(alert);
}
}
