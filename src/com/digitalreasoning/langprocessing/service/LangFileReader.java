/*****************************
 * The file reader reads a file. In this implementation all the contents 
 * of the file are read in a string. Ideally I would have liked to constrain the read to a
 *  a certain size and read iteratively , so large files dont take up too much memory.
 *  
 *  the file reader calls a parser interface
 * The parser interface has methods to parse the contents into sentences and sentences
 * into words. 
 * 
 * A list of sentences is created as an end result.
 * Author : Mahesh Trikannad
 */
package com.digitalreasoning.langprocessing.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.digitalreasoning.langprocessing.model.AnalyzedFile;
import com.digitalreasoning.langprocessing.model.Sentence;
import com.digitalreasoning.langprocessing.model.Word;

public class LangFileReader {
	private String fileName;
	private LangParser parser;
	private List<Sentence> sentList;
	
	// The below is the output
	private AnalyzedFile analyzedFile = new AnalyzedFile();
	public LangFileReader(String fileName) {
		this.fileName = fileName;
		analyzedFile.setName(fileName);
	}
	
	public void setParser(LangParser parser) {
		this.parser = parser;
	}
	
	

	public void readandParse() {

		StringBuilder myString = new StringBuilder();

		try {

			
			
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String strLine;
			while ( (strLine = reader.readLine()) != null) {
				myString.append(strLine).append('\n');
			}
			sentList = parser.parseSentence(myString.toString());
			for(Sentence sentence:sentList) {
				List<Word> wordList = parser.parseWord(sentence.getSentence());
				sentence.setWordList(wordList);
			}
			analyzedFile.setSentenceList(sentList);

			reader.close();
		}
		catch(IOException ioe) {
			System.out.println("IOException with file:"+fileName);
			ioe.printStackTrace();
		}
		finally {

		}
	}
	
	/**********
	 * return the output of the read
	 * and parse
	 * @return
	 */
	public AnalyzedFile  getAnalyzedFile() {
		return analyzedFile;
	}
	
	/*******************
	 * Return XML version of the sentence and word structure
	 * @return
	 */
	public String toXml() {
		StringBuilder outstr = new StringBuilder();
		outstr.append("<?xml version=\"1.0\"");
		outstr.append("<file>");
		
		for(Sentence sentence:sentList) {
			outstr.append("<sentence>");
			for(Word word:sentence.getWordList()) {
				outstr.append("<word");
				if( word.isNoun()) {
					outstr.append(" noun=true>");
				}else
				{
					outstr.append(" noun=false>");
				}
				outstr.append(word.getWord());
				outstr.append("</word>");
			}
			outstr.append("</sentence>");
		}
		outstr.append("</file>");
		return outstr.toString();
		
		
	}

}
