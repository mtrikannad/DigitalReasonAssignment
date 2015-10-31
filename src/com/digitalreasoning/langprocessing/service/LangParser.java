/*****************************
 *  Interface for a parser.
 *  Methods to parse sentence and
 *  word.
 * Author : Mahesh Trikannad
 */
package com.digitalreasoning.langprocessing.service;

import java.util.List;

import com.digitalreasoning.langprocessing.model.Sentence;
import com.digitalreasoning.langprocessing.model.Word;

public interface LangParser {
List<Sentence> parseSentence(String instr);
List<Word>  parseWord(String instr);

}
