package by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.parser.stringOperations;

import java.util.List;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Sentence;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Word;

public class StringCreation {
	public static String createStringFromSentenceList(List<Sentence> list) {
		StringBuilder builder = new StringBuilder();
		for (Sentence sentence : list) {
			String res = sentence.returnTextPart();
			builder.append(res);
			builder.append("\n");
		}
		
		String result = builder.toString();
		
		return result;
		
	}
	
	public static String createStringFromWordList(List<Word> list) {
		StringBuilder builder = new StringBuilder();
		for (Word word : list) {
			String res = word.returnTextPart();
			builder.append(res);
			builder.append("\n");
		}
		
		String result = builder.toString();
		
		return result;
		
	}

}
