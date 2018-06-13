package com.codecool.hangman;

import java.util.*;

public class Interface {

    public void printScreen(char[] guessedWord, int missedGuesses, ArrayList<String> missedLetters) {
        for (char ch: guessedWord) {
            System.out.print(ch + " ");
        }
        System.out.println("\t" + String.valueOf(missedGuesses) + "/7\t" + Arrays.deepToString(missedLetters.toArray()));
	switch(missedGuesses) {
	    case 1: this.printGallows1();		
	            break;
	    case 2: this.printGallows2();		
		    break;
	    case 3: this.printGallows3();		
		    break;
	    case 4: this.printGallows4();		
		    break;
	    case 5: this.printGallows5();		
		    break;
	    case 6: this.printGallows6();		
		    break;
	    default: this.printGallows();
		     break;
	}
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

    public void printLogo() {
	System.out.println(" _ ");		 	                                           
	System.out.println("| |");
	System.out.println("| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  ");
	System.out.println("| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ ");
	System.out.println("| | | | (_| | | | | (_| | | | | | | (_| | | | |");
	System.out.println("|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|");
	System.out.println("		    __/ |");
	System.out.println("		   |___/ ");
	}

    public void printGallows() {
	System.out.println("   	   ____");
	System.out.println("	  |    |");   
	System.out.println("	  |    "); 
	System.out.println("	  |   ") ;    
	System.out.println("	  |   ");
	System.out.println("	  |   ");
	System.out.println("	 _|_");
	System.out.println("	|   |______");
	System.out.println("	|          |");
	System.out.println("	|__________|");
	
	}

    public void printGallows1() {
	System.out.println("   	   ____");
	System.out.println("	  |    |");  
	System.out.println("	  |    O"); 
	System.out.println("	  |   ") ;    
	System.out.println("	  |   ");
	System.out.println("	  |   ");
	System.out.println("	 _|_");
	System.out.println("	|   |______");
	System.out.println("	|          |");
	System.out.println("	|__________|");
	
	}

    public void printGallows2() {
	System.out.println("   	   ____");
	System.out.println("	  |    |");    
	System.out.println("	  |    O");
	System.out.println("	  |    |");    
	System.out.println("	  |   ");
	System.out.println("	  |   ");
	System.out.println("	 _|_");
	System.out.println("	|   |______");
	System.out.println("	|          |");
	System.out.println("	|__________|");
	
	}

     public void printGallows3() {
	System.out.println("   	   ____");
	System.out.println("	  |    |");   
	System.out.println("	  |    O");
	System.out.println("	  |    |/");    
	System.out.println("	  |   ");
	System.out.println("	  |   ");
	System.out.println("	 _|_");
	System.out.println("	|   |______");
	System.out.println("	|          |");
	System.out.println("	|__________|");
	
	}

    public void printGallows4() {
	System.out.println("   	   ____");
	System.out.println("	  |    |");  
	System.out.println("	  |    O") ;
	System.out.println("	  |   \\|/");    
	System.out.println("	  |   ");
	System.out.println("	  |   ");
	System.out.println("	 _|_");
	System.out.println("	|   |______");
	System.out.println("	|          |");
	System.out.println("	|__________|");
	
	}

    public void printGallows5() {
	System.out.println("   	   ____");
	System.out.println("	  |    |");   
	System.out.println("	  |    O");
	System.out.println("	  |   \\|/");    
	System.out.println("	  |    |");
	System.out.println("	  |   ");
	System.out.println("	 _|_");
	System.out.println("	|   |______");
	System.out.println("	|          |");
	System.out.println("	|__________|");
	
	}

    public void printGallows6() {
	System.out.println("   	   ____");
	System.out.println("	  |    |");   
	System.out.println("	  |    O");
	System.out.println("	  |   \\|/");    
	System.out.println("	  |    |");
	System.out.println("	  |   /");
	System.out.println("	 _|_");
	System.out.println("	|   |______");
	System.out.println("	|          |");
	System.out.println("	|__________|");
	
	}

    public void printGallows7() {
	System.out.println("   	   ____");
	System.out.println("	  |    |") ;   
	System.out.println("	  |    O"); 
	System.out.println("	  |   \\|/");  
	System.out.println("	  |    |");
	System.out.println("	  |   / \\");
	System.out.println("	 _|_");
	System.out.println("	|   |______");
	System.out.println("	|          |");
	System.out.println("	|__________|");
	
	}
}
