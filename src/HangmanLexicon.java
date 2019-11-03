/*
 * File: HangmanLexicon.java
 * -------------------------
 * Name: Hongyou Lin
 * 
 * This file implements the HangmanLexicon class that takes care 
 */

import java.io.*;
import java.util.*;

import acm.util.*;

public class HangmanLexicon {

	/** Declare Instance Variables you need here */
	private ArrayList<String> Lexicon = new ArrayList<String>();
	
	/** HangmanLexicon constructor. Do any initialization of your lexicon here. */
	public HangmanLexicon() {
		String words;
		try {
			BufferedReader newWords = new BufferedReader(new FileReader("HangmanLexicon.txt"));   // search for the .txt document based on its current super folder;
			while ((words = newWords.readLine()) != null) {   // condense the while-if codes into one line;
				Lexicon.add(words);
			}
			newWords.close();
		} catch (IOException e) {
			 throw new ErrorException(e);  // might output 
		}
	}
	
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return Lexicon.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		if(index >= 10)   // distinguish from the switch case where there are 10 words (prevent index overuse);
			return Lexicon.get(index - 10);  // 
		else{
		  switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");
		  }
		}
	}
}
