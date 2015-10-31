/************************
 * Enacapsulate a sentence.
 * Sentence contains a list of words
 *  Author : Mahesh Trikannad
 */
package com.digitalreasoning.langprocessing.model;

import java.util.List;

public class Sentence {
	private String sentence;
	private List<Word> wordList;
	
	public String getSentence() {
		return sentence;
	}
	
	public List<Word> getWordList() {
		return wordList;
	}
	
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	public void setWordList(List<Word> wordList) {
		this.wordList = wordList;
	}
	

}
