/************************
 * encapsulates the file to be analyzed.
 * Composes of a list of sentences
 *  Author : Mahesh Trikannad
 */
package com.digitalreasoning.langprocessing.model;

import java.util.ArrayList;
import java.util.List;

public class FileTobeAnalyzed {
	private String fileName;
	List<Sentence> sentenceList = new ArrayList<Sentence>();
	
	public String getName() {
		return fileName;
	}
	
	public void setName(String name) {
		this.fileName = name;
	}
	
	public void setSentenceList(List<Sentence> sentenceList) {
		this.sentenceList = sentenceList;
	}
	
	public List<Sentence> getSentenceList() {
		return sentenceList;
	}

}
