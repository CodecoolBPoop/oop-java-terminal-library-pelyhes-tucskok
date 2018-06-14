package com.codecool.hangman;
import com.codecool.termlib.*;
import java.util.*;

public class Hangman	{
		
		private static final String menuText = "Menu\n1.Single Mode\n2.Multi\n3.High score\n4.Exit game\n\nEnter your choice: ";
		private static final char[] menuPoints = {'1','2','3','4'};
		private static Terminal terminal = new Terminal();
		private static Interface inter = new Interface();

		public static void menu() {
		   Scanner scanner = new Scanner(System.in);
		   
			
		   char number = 'x';
		   while (new String(menuPoints).indexOf(number) == -1) { 		
			terminal.clearScreen();	
			inter.printLogo();		
			System.out.println(menuText);
			number = scanner.next().charAt(0);
		   }
		   
		   switch(number) {
			case '1':
				startSingleMode();
				break;
			case '2':
				startMultiMode();
				break;
			case '3':
				terminal.clearScreen();	
				inter.printHighScore();
				inter.goBackToMenu("Press any button to go back!");
				break;
			case '4':
				break;
		   }
		}

		public static void startSingleMode() {
		  ArrayList words = new ArrayList();
		  try {
		  	words = Interface.readFromTxt("countries.txt");
		  } catch (Exception e){
		 	System.out.println("File not found!");		
		  }	
			
		  Random randomGenerator = new Random();
		  int index = randomGenerator.nextInt(words.size());
		  String word = words.get(index).toString();

		  Game game = new Game(word);
		  game.startGame();
		  
		}

		public static void startMultiMode() {
		  terminal.clearScreen();
		  System.out.println("Enter the word to be guessed: ");

		  Scanner scanner = new Scanner(System.in);
		  String word = scanner.nextLine();
		  
		  Game game = new Game(word);
		  game.startGame();	

		}

		
		public static void main(String[] args) {
			menu();
		}
}
