package com.codecool.termlib;
import java.util.Scanner;

public class Test{
	public static void main( String[] args) {
		Terminal reset = new Terminal();
		Scanner sc = new Scanner(System.in);
		System.out.println("Reset the screen");
		String clear = sc.nextInt();
		if (clear == 5) {
			System.out.println("\033[" + "2J");
		}	
	}
}
