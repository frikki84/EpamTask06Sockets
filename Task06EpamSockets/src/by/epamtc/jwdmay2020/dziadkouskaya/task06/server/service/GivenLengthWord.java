package by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service;


import java.util.ArrayList;
import java.util.List;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Sentence;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Text;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Word;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.listcreate.ListCreation;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.listcreate.StringCreation;


/*Во всех вопросительных предложениях найти и напечатать слова заданной длины без повторений*/

public class GivenLengthWord implements ServiceResult {
	private Text text;

	private int givenSize;

	public GivenLengthWord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GivenLengthWord(Text text) {
		super();
		this.text = text;
	}

	public GivenLengthWord(Text text, int givenSize) {
		super();
		this.text = text;
		this.givenSize = givenSize;
	}

	@Override
	public String findResultOfTextOperations() {
		List<Sentence> sentences = ListCreation.createSentenceList(this.text);

		List<Sentence> interrogativeSentences = new ArrayList<Sentence>();

		for (Sentence sentence : sentences) {
			
			if (sentence.getLastSymbol() == '?') {
				interrogativeSentences.add(sentence);
			}
		}

		
		
		List<Word> givenLengthWordList = new ArrayList<>();

		for (Sentence sentence : interrogativeSentences) {

			for (Word word : sentence.getSentence()) {

				if (word.getWord().length() == this.getGivenSize()) {
					givenLengthWordList.add(word);
				}
			}

		}

		for (int i = 0; i < givenLengthWordList.size(); i++) {
			for (int j = i + 1; j < givenLengthWordList.size(); j++) {
				if (givenLengthWordList.get(i).getWord().equalsIgnoreCase(givenLengthWordList.get(j).getWord())) {
					givenLengthWordList.remove(j);
				}
			}
		}

		String result = StringCreation.createStringFromWordList(givenLengthWordList);

		return result;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public int getGivenSize() {
		return givenSize;
	}

	public void setGivenSize(int givenSize) {
		this.givenSize = givenSize;
	}

}
