package by.epamtc.jwdmay2020.dziadkouskaya.task06.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextPartInterface, Serializable {

	private String paragraphString;

	List<Sentence> paragraph = new ArrayList();

	public Paragraph() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paragraph(String paragraphString) {
		super();
		this.paragraphString = paragraphString;
	}

	public Paragraph(List<Sentence> paragraph) {
		super();
		this.paragraph = paragraph;
	}

	public void addSentenceToParagraph(Sentence sentence) {
		if (sentence != null) {
			paragraph.add(sentence);
		}
	}

	public void removeSentenceFromContainer(Sentence sentence) {
		paragraph.remove(sentence);
	}

	@Override
	public String returnTextPart() {
		String result = "";
		if (this.paragraph != null) {

			for (Sentence sentence : paragraph) {
				result += sentence.returnTextPart();
			}
		} else {
			result = this.paragraphString;
		}

		return result;
	}

	public List<Sentence> getParagraph() {
		return paragraph;
	}

	public void setParagraph(List<Sentence> paragraph) {
		this.paragraph = paragraph;
	}

	public String getParagraphString() {
		return paragraphString;
	}

	public void setParagraphString(String paragraphString) {
		this.paragraphString = paragraphString;
	}

}
