/***************************
 * static set of nouns loaded at startup
 * by NounFileLoader
 */
package com.digitalreasoning.langprocessing.model;

import java.util.HashSet;
import java.util.Set;

public class LangNouns {

	private static Set<String> nouns = new HashSet<String>();
	
	public static  void addNoun(String noun) {
		nouns.add(noun);
	}
	
	public static  boolean isNoun(String noun) {
		return nouns.contains(noun);
	}
	
}
