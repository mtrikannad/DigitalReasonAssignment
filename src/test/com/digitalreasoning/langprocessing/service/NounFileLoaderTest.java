/***************************
 * 
 */
package test.com.digitalreasoning.langprocessing.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.digitalreasoning.langprocessing.model.LangNouns;
import com.digitalreasoning.langprocessing.service.NounFileLoader;



public class NounFileLoaderTest {
	@Test
	public void testNounReader() {
		 NounFileLoader.loadNouns("NER.txt");
		
	
		
		assertTrue(LangNouns.isNoun("Franz"));
	    assertFalse(LangNouns.isNoun("Franz Ferdinand"));
	 
	    assertTrue(LangNouns.isNoun("England"));
	    
		
	}
}
