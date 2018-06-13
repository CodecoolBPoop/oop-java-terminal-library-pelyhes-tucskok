#!/bin/sh
javac com/codecool/termlib/*.java
jar cf termlib.jar com/codecool/termlib/*.class
javac -cp termlib.jar com/codecool/hangman/*.java
java com.codecool.hangman.Hangman
