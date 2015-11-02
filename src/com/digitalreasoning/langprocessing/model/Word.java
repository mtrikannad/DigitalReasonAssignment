/************************************
 * Encapsulate a word. Contains
 * a word and an indication if it is a noun
 * or not.
 *  Author : Mahesh Trikannad
 */
package com.digitalreasoning.langprocessing.model;

public class Word {
private String word;
boolean isNoun = false; // Not a noun by default

public String getWord() {
	return word;
}

public void setWord(String word) {
	this.word = word;
}

public boolean isNoun() {
	return isNoun;
}

public void setIsNounFlag(boolean flag) {
	this.isNoun = flag;
}

}
