package by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.parser;

import java.util.List;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Paragraph;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Sentence;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Text;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Word;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.parser.stringOperations.StringDivicion;



////divide String to Text (including Paragraphs, Sentences,Words)
public class TextNotifier implements InfoFromDaoToService {

	@Override
	public Text returnInformationForTextAnalysis(String string) {
		Text text = new Text();
		List<String> paragraphList = StringDivicion
				.splitStringToParagraphes(StringDivicion.splitStringToCodeBlocks(string));

		for (String part : paragraphList) {
			List<String> sentenceList = StringDivicion.splitStringToSentenses(part);

			Paragraph paragraph = new Paragraph();

			for (String item : sentenceList) {
				List<String> wordList = StringDivicion.splitStringToWords(item);

				Sentence sentence = new Sentence();

				for (String wor : wordList) {
 
					Word word = new Word(wor);
									
					sentence.addWordToContainer(word);
				}
				
				paragraph.addSentenceToParagraph(sentence);
				
				
			}

			text.addParagraphToContainer(paragraph);
		}

		
		return text;
	}

}
