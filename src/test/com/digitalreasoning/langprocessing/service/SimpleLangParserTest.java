package test.com.digitalreasoning.langprocessing.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.digitalreasoning.langprocessing.model.Sentence;
import com.digitalreasoning.langprocessing.model.Word;
import com.digitalreasoning.langprocessing.service.LangParser;
import com.digitalreasoning.langprocessing.service.SimpleLangParser;

public class SimpleLangParserTest {

	@Test
	public void testSentence() {
		LangParser parser = new SimpleLangParser();
		
		
		List<Sentence> sent = parser.parseSentence("My Name is \"Mahesh Trikannad\". How are you.");
		
		/********
		for(Word word:words) {
			System.out.println("Word: "+word.getWord());
		}
		********/
		for(Sentence sentence:sent) {
			System.out.println("Sentence:"+sentence.getSentence());
			
		}
		assertEquals(sent.size(),2);
		
		
		
	}
	
	@Test
	public void testWord() {
		LangParser parser = new SimpleLangParser();
		
		
		List<Word> words = parser.parseWord("My Name is \"Mahesh Trikannad\"");
		/****
		for(Word word:words) {
			System.out.println("Word: "+word.getWord());
		}
		*********/
		// Broken up as separate words . " is also considered a word.
		assertEquals(words.get(0).getWord(),"My");
		System.out.println(words.get(1).getWord());
		assertEquals(words.get(1).getWord(),"Name");
		assertEquals(words.get(2).getWord(),"is");
		assertEquals(words.get(4).getWord(),"Mahesh");
		assertEquals(words.get(5).getWord(),"Trikannad");
		
		
		
		
		
		
	}

}
