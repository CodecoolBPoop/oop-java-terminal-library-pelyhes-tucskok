#!/bin/sh
javac src/com/codecool/termlib/*.java
jar cf termlib.jar src/com/codecool/termlib/*.class
javac -cp termlib.jar src/com/codecool/hangman/*.java
java -cp src com.codecool.hangman.Hangman
