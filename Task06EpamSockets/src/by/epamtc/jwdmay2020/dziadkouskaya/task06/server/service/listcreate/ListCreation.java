package by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.listcreate;


import java.util.ArrayList;
import java.util.List;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Paragraph;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Sentence;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Text;



public class ListCreation {

	public static List<Sentence> createSentenceList(Text text) {
		List<Paragraph> paragraphs = text.getAllText();

		List<Sentence> sentences = new ArrayList();

		for (Paragraph paragraph : paragraphs) {
			sentences.addAll(paragraph.getParagraph());
		}

		return sentences;

	}
}
