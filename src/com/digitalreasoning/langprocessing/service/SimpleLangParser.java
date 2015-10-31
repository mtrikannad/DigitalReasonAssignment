/*******************
 * Simple parser uses java BreakIterator
 * to break into sentences and words
 *  Author : Mahesh Trikannad
 */
package com.digitalreasoning.langprocessing.service;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import com.digitalreasoning.langprocessing.model.Sentence;
import com.digitalreasoning.langprocessing.model.Word;

public class SimpleLangParser implements LangParser {

	@Override
	public List<Sentence> parseSentence(String instr) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		 // To break it into sentences
		List<Word> wordList = new ArrayList<Word>();
        BreakIterator boundary = BreakIterator.getWordInstance();
        boundary.setText(sentence);
        int start = boundary.first();
        for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
            //System.out.println(sentence.substring(start, end));
            Word word = new Word();
            word.setWord(sentence.substring(start, end));
            wordList.add(word);
        }
		

		return wordList;
	}

}
