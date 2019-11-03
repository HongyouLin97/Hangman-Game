/*
 * File: Hangman.java
 * ------------------
 * Name: Hongyou Lin
 * 
 * This program will eventually implement the Hangman game.
 * 
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	
	private RandomGenerator rgen = new RandomGenerator();
	
	private HangmanLexicon Lexicon = new HangmanLexicon();
	
	private HangmanCanvas canvas;
	
	private final String SecretWords = randomWords();  // the variable SecretWord that remains unchanged for a single game;
	
	private String IncorrectLetter = "";
	
	public void init() {
		resize(600,600);
		canvas = new HangmanCanvas();
		setLayout(new GridLayout(1, 2));
		add (canvas);
		validate();
	}
	
    public void run() {
		setUp();
		playGame();
	}
    
    // set up the basic beginning words document for the console program;
    private void setUp() {
    	canvas.reset();
    	println("Welcom to Hangman! ");
    	String lettersLine = lettersLine();
    	println("The word now looks like this: " + lettersLine);
    	canvas.displayWord(lettersLine);
    	int chancesCount = chancesCount();
    	println("You have " + chancesCount + " guesses left.");  
    }
    
    // chances that the player has to win the game;
    private int chancesCount() {
    	int chancesCount = 8;
    	return chancesCount;
    }
    
    // creates the dash line at the beginning of the game;
    private String lettersLine() {
    	String result = "";
    	int number = SecretWords.length();
    	for (int i = 0; i < number; i++) {
    		result = result + "-";
    	}
    	return result;
    }
    
    // randomly selects a word from Lexcion;
    private String randomWords() {
    	int wordsCount = Lexicon.getWordCount()-1;
    	String SecretWords = Lexicon.getWord(rgen.nextInt(0, wordsCount + 10));
    	return SecretWords;
    }
    
    // check the letter input with the secret words;
    private void checkTheLetter() {
    	int chancesCount = chancesCount();
    	String result = lettersLine();
    	char character = 0;
    	
    	// programs that check for matches between the word and the letter input;
    	while (chancesCount > 0) {  
			String input = readLine("Your guess: ");
			input = input.toUpperCase();
			
			// program only checks for input's validity;
			while (true) {
				if (input.length() > 1) {
					input = readLine("Sorry, only accept one character for input each time. Your guess: ");
				}
				else if (input.length() == 1) { 
					character = input.charAt(0);
					break;
				}
				input = input.toUpperCase();
        	}
			
			// first letter-check for existence in the SecretWord;
			if (SecretWords.indexOf(character) == -1) {
				chancesCount--;
				println("There are no " + character +"'s in the word. ");
				IncorrectLetter += character;
				canvas.noteIncorrectGuess(IncorrectLetter);
			} 
			else if (SecretWords.indexOf(character) != -1) {
				println("That guess is correct. ");
			}
			
    		// help to check for every single letter and update the letter that is correctly guessed;
			for (int i = 0; i < SecretWords.length(); i++) {   
				char ch = SecretWords.charAt(i);
        			if (character == ch) { 
        				if (i == 0) {        // two situations to create the new string with updated letter;
        					result = character + result.substring(1);
        				}
        				else if (i > 0) {   // when the character is not the first letter, the result needs to be constructed by fragments of words;
        					result = result.substring(0, i) + character + result.substring(i+1);
        				} 
        			}
			}
			canvas.displayWord(result);
			
			// display the messages when check-letter is finished and the result is updated (methods in the main while loop);
			println("The word now looks like this: " + result);
			println("You have " + chancesCount + " guesses left. ");

			// check for status of the game (out of the main while loop);
			if (chancesCount == 0) {
				println("You're completely hung.");
				println("The word was: " + SecretWords);
    			println("You lose. ");
    			break;
			} 
			else if (SecretWords.equals(result)) {
				println("You guessed the word: " + SecretWords);
				println("You win. ");
				break;
			}
    	}
    }
    
    private void playGame() {
    	checkTheLetter();
    }
    
    
    
    
    
    
}
