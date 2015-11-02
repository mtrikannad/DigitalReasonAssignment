/**********************************
 * This is the final output of the program
 * Contains a static list of AnalyzedFile.
 * Access to the list needs to be synchronized since multiple threads
 * can insert to it.
 */
package com.digitalreasoning.langprocessing.model;

import java.util.ArrayList;
import java.util.List;

public class AnalyzedOutput {
	private static List<AnalyzedFile> analyzedFileList = new ArrayList<AnalyzedFile>();

	// This will be called by multiple threads
	public static synchronized void setAnalyzedFile(AnalyzedFile file) {
		//System.out.println("Adding to analFileList "+Thread.currentThread().getName());
		analyzedFileList.add(file);
		//System.out.println("Adding to analFileList Done");
	}
	
	public static void reset() {
		analyzedFileList.clear();
	}
	
	// Return the final output of this project
	public static List<AnalyzedFile> getAnalyzedList() {
		return analyzedFileList;
	}
}
