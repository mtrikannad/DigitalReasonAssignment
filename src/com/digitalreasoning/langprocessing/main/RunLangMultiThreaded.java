/*****************************************
 * Run multiple threads to process multiple files 
 * for natural language parsing

 * Author Mahesh Trikannad
 */
package com.digitalreasoning.langprocessing.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.digitalreasoning.langprocessing.exception.DigitalReasoningException;
import com.digitalreasoning.langprocessing.model.AnalyzedFile;
import com.digitalreasoning.langprocessing.model.AnalyzedOutput;
import com.digitalreasoning.langprocessing.service.LangFileReader;
import com.digitalreasoning.langprocessing.service.LangParser;
import com.digitalreasoning.langprocessing.service.NounFileLoader;
import com.digitalreasoning.langprocessing.service.SimpleLangParser;

public class RunLangMultiThreaded {

	public static void runMultiThreads(String zipFileName) throws DigitalReasoningException {

		// Reset the output list before starting
		AnalyzedOutput.reset();
		
		// set thread pool size to 5, we dont want too many threads
		// running at the same time.
		ExecutorService executor = Executors.newFixedThreadPool(5);

		try {
			ZipFile zipFile = new ZipFile(zipFileName);	
			Enumeration<? extends ZipEntry> entries =  zipFile.entries();
			while(entries.hasMoreElements()) {

				ZipEntry entry = entries.nextElement();
				String fileName =  entry.getName();

				InputStream in = zipFile.getInputStream(entry);
				if( !entry.isDirectory() ) {
					//Ignore the MACOSX files
					if( fileName.indexOf("MACOS") == -1){
						//System.out.println(fileName);
						LangFileReader rdr = new LangFileReader(in,fileName);
						LangParser parser = new SimpleLangParser();
						rdr.setParser(parser);

						// the below does most of the work
						executor.execute(rdr);
					}
					
				}
				
			}
			executor.shutdown();
			while (!executor.isTerminated()) {
			}
			
			zipFile.close();

		}
		catch(IOException ioe) {
			ioe.printStackTrace();
			throw new DigitalReasoningException("Cound not open file"+zipFileName);
		}
		


		List<AnalyzedFile> finalList = AnalyzedOutput.getAnalyzedList();
		for(AnalyzedFile file:finalList) {
			System.out.println("Done analyzing"+file.getName());
		}
		

	}

	/***********************************************
	 * Main method to run the natural lang processor
	 * with multiple thresds
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {
		
		// Load the nouns first
		NounFileLoader.loadNouns("NER.txt");
		// call method to run multiple threads to process files
		runMultiThreads("nlp_data.zip");


	}

}
