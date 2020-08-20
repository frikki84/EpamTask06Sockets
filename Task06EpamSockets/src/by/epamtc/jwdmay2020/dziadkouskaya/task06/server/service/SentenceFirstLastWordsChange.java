package by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service;

import java.util.List;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Sentence;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Text;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Word;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.listcreate.ListCreation;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.listcreate.StringCreation;


/*В каждом предложении поменять местами первое и последнее слово*/

public class SentenceFirstLastWordsChange implements ServiceResult {

	private Text text;

	public SentenceFirstLastWordsChange(Text text) {
		super();
		this.text = text;
	}

	public SentenceFirstLastWordsChange() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String findResultOfTextOperations() {
		List<Sentence> sentences = ListCreation.createSentenceList(this.text);

		for (int i = 0; i < sentences.size(); i++) {
			
			if (sentences.get(i).getSentence().size() > 1) {

				List<Word> wordList = sentences.get(i).getSentence();

				Word firstWord = wordList.get(0);
				

				Word lastWord = wordList.get(wordList.size() - 1);
				
				//System.out.println("firstword = " + firstWord.getWord() + " lastword = " + lastWord.getWord());

				
				wordList.remove(wordList.size() - 1);
				wordList.remove(0);

				wordList.add(0, lastWord);
				wordList.add(firstWord);

				sentences.get(i).setSentence(wordList);
			}
		}

		String result = StringCreation.createStringFromSentenceList(sentences);

		return result;
	}

}
