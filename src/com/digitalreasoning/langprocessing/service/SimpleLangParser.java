/*******************
 * Simple parser uses java BreakIterator
 * to break into sentences and words
 *  Author : Mahesh Trikannad
 */
package com.digitalreasoning.langprocessing.service;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.digitalreasoning.langprocessing.model.LangNouns;
import com.digitalreasoning.langprocessing.model.Sentence;
import com.digitalreasoning.langprocessing.model.Word;

public class SimpleLangParser implements LangParser {

	@Override
	public List<Sentence> parseSentence(String instr) {
		
		List<Sentence> sentenceList = new ArrayList<Sentence>();
		BreakIterator boundary = BreakIterator.getSentenceInstance();
		boundary.setText(instr);
		int start = boundary.first();
		for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
			// System.out.println(instr.substring(start, end));
			Sentence sentence = new Sentence();
			sentence.setSentence(instr.substring(start, end));
			sentenceList.add(sentence);
		}
		return sentenceList;
	}

	@Override
	public List<Word> parseWord(String sentence) {
		
	
		List<Word> wordList = new ArrayList<Word>();
		BreakIterator boundary = BreakIterator.getWordInstance(Locale.US);
		boundary.setText(sentence);
		int start = boundary.first();
		for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
			//System.out.println(sentence.substring(start, end));

			String myword = sentence.substring(start, end);
			myword = myword.trim();
			if(myword.isEmpty())
				continue;

			Word word = new Word();
			word.setWord(myword);
			if( LangNouns.isNoun(myword) )
				word.setIsNounFlag(true);
			else
				word.setIsNounFlag(false);
			wordList.add(word);
		}


		return wordList;
	}

}
