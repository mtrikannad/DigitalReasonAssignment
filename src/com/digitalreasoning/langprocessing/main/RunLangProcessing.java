package com.digitalreasoning.langprocessing.main;

import com.digitalreasoning.langprocessing.service.LangFileReader;
import com.digitalreasoning.langprocessing.service.LangParser;
import com.digitalreasoning.langprocessing.service.SimpleLangParser;

public class RunLangProcessing {

	/***********************
	 * Run the reader and print
	 * an XML output
	 * @param args
	 */
	public static void main(String[] args) {
	
		LangFileReader rdr = new LangFileReader("nlp_data.txt");
		LangParser parser = new SimpleLangParser();
		rdr.setParser(parser);
		
		rdr.readandParse();
		System.out.println(rdr.toXml());

	}

}
