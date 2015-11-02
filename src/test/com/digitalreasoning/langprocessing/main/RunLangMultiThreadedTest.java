package test.com.digitalreasoning.langprocessing.main;

import static org.junit.Assert.*;

import org.junit.Test;

import com.digitalreasoning.langprocessing.exception.DigitalReasoningException;
import com.digitalreasoning.langprocessing.main.RunLangMultiThreaded;
import com.digitalreasoning.langprocessing.model.AnalyzedOutput;



public class RunLangMultiThreadedTest  {

	@Test(expected=DigitalReasoningException.class)
	public void testException() throws DigitalReasoningException {

		// invalid zip file test
		RunLangMultiThreaded.runMultiThreads("nlp_data.zip1");


	}

	@Test
	public void testMultiThreadsOutput() throws DigitalReasoningException {


		RunLangMultiThreaded.runMultiThreads("nlp_data.zip");
		assertNotNull(AnalyzedOutput.getAnalyzedList());
		assertEquals(AnalyzedOutput.getAnalyzedList().size(),10);


	}
	
	@Test
	public void testMultiThreadsSentences() throws DigitalReasoningException {


		RunLangMultiThreaded.runMultiThreads("nlp_data.zip");
		assertNotNull(AnalyzedOutput.getAnalyzedList());
		assertNotNull(AnalyzedOutput.getAnalyzedList().get(0).getSentenceList());


	}

}
