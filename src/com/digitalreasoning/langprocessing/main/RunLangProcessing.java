/************************
 *  Main Java program to run
 *  a single threaded version of
 *  the processort. Loads nouns and invokes
 *  the LangFileReader. LangFileReader.getFileToBeAnalyzed
 *  encapsulates the parsed sentences and words for that 
 *  file.
 *  Author : Mahesh Trikannad
 */

package com.digitalreasoning.langprocessing.main;

import com.digitalreasoning.langprocessing.exception.DigitalReasoningException;
import com.digitalreasoning.langprocessing.service.LangFileReader;
import com.digitalreasoning.langprocessing.service.LangParser;
import com.digitalreasoning.langprocessing.service.NounFileLoader;
import com.digitalreasoning.langprocessing.service.SimpleLangParser;

public class RunLangProcessing {

	/***********************
	 * Run the reader and print
	 * an XML output
	 * @param args
	 */
	public static void main(String[] args) throws DigitalReasoningException {

		// Load the nouns first
		NounFileLoader.loadNouns("NER.txt");


		LangFileReader rdr = new LangFileReader("nlp_data.txt");
		LangParser parser = new SimpleLangParser();
		rdr.setParser(parser);

		// the below does most of the work
		rdr.readandParse();
		System.out.println(rdr.toXml());

	}

}
