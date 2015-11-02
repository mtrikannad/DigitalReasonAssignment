/*******************
 * A singleton class , the loadNouns method
 * creates an instance and calls
 * the readandparse method internally, which reads nouns
 * from the passed in filename and loads them to
 * the a static structure in LangNouns
 * 
 *  Author : Mahesh Trikannad
 */
package com.digitalreasoning.langprocessing.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.digitalreasoning.langprocessing.model.LangNouns;
import com.digitalreasoning.langprocessing.model.Word;

public class NounFileLoader {
	private String fileName;
	private static NounFileLoader loader = null;
	
	private NounFileLoader( ) {
		
	}
	
	private NounFileLoader(String fileName ) {
		this.fileName = fileName;
	}
	
	/**************************************
	 * Singleton method. Call this to load
	 * nouns
	 * @param fileName
	 */
	public static void loadNouns(String fileName) {
		
		if ( loader == null) {
			loader = new NounFileLoader(fileName);
			loader.readandParse();
		}

	}

	/**********************************************
	 * Read all nouns from a file
	 * Simplistic parsing break into words
	 * and add them to a Set
	 */
	private void readandParse() {

		

		try {

			
			
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String strLine;
			LangParser wordParser = new SimpleLangParser();
			while ( (strLine = reader.readLine()) != null) {
				
				List<Word> words = wordParser.parseWord(strLine);
				for(Word word:words) {
				LangNouns.addNoun(word.getWord());
				}
			}
			reader.close();
		
		}
		catch(IOException ioe) {
			
		}
		finally {
			
		}
		
	}
			
}
