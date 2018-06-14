package com.codecool.hangman;
import java.io.*;
import java.util.*;

public class FileHandler {
    
    //public static int HIGHSCORECOUNT = 0;
    

    public static void writeFile(String players, String name, int score) throws IOException {
	
	String scoreAsString = Integer.toString(score);	
	//HIGHSCORECOUNT++;
	//String highScoreCount = Integer.toString(HIGHSCORECOUNT);
        try (FileWriter fileWriter = new FileWriter("highScore.txt")) {
        fileWriter.write(scoreAsString + " ");
        fileWriter.write(name + ",");
        fileWriter.write(players);
	fileWriter.close();
	}
    }

    public static String readFile() throws IOException{
	
	FileReader fileReader = new FileReader("highScore.txt");
        BufferedReader Buff = new BufferedReader(fileReader);
        String s="";
        //s=bufferedReader.readLine();
	StringBuffer stringBuffer = new StringBuffer("");
	String line = null;
	while ((line = Buff.readLine()) != null) {
    	    stringBuffer.append(line);
	}
	fileReader.close();
	String highScoreString = String.valueOf(stringBuffer);
	return highScoreString;
    }

    public static String getHighScoreFromFile() {
	String readFile = "";
	try {
	  readFile();
	  readFile = readFile();
	   	
		}
	catch(IOException e) {
	  e.printStackTrace();
		}
    	return readFile;
    }
    
    public static void writeHighScoreToFile(String players, String name, int score) {
	try {
            writeFile(players, name, score);
	}
        catch(IOException e) {
            e.printStackTrace();
	}
    }

    public static String sortHighScore() {
	String highScore = getHighScoreFromFile();
	String[] values = highScore.split(",");
	for (int i = 1; i < values.length; i++) {
	    char firstChar = values[i - 1].charAt(0);
	    char secondChar = values[i].charAt(0);
	    if (Integer.parseInt(String.valueOf(firstChar)) < Integer.parseInt(String.valueOf(secondChar))) {
		String temp =values[i - 1];
		values[i - 1] = values[i];
		values[i] = temp;
	    }
	}
	String sortedHighScore = Arrays.toString(values).substring(1, Arrays.toString(values).length()-1);
        return " " + sortedHighScore;
    }
}
