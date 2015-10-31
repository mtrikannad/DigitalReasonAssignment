package test.com.digitalreasoning.langprocessing.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.digitalreasoning.langprocessing.model.FileTobeAnalyzed;
import com.digitalreasoning.langprocessing.service.LangFileReader;
import com.digitalreasoning.langprocessing.service.LangParser;
import com.digitalreasoning.langprocessing.service.SimpleLangParser;

public class LangFileReaderTest {

	
	
	@Test
	public void testFileReader() {
		LangFileReader rdr = new LangFileReader("nlp_data.txt");
		LangParser parser = new SimpleLangParser();
		rdr.setParser(parser);
		
		rdr.readandParse();
		FileTobeAnalyzed fileAnal = rdr.getFileTobeAnalyzed();
		assertNotNull(fileAnal);
		assertNotNull(fileAnal.getSentenceList());
		
	}

}
