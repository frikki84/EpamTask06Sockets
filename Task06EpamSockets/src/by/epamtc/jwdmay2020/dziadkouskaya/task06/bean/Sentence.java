package by.epamtc.jwdmay2020.dziadkouskaya.task06.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextPartInterface, Serializable {
	private String sentenceString;

	List<Word> sentence = new ArrayList<>();

	private char firstSymbol;
	private char lastSymbol;

	public Sentence() {
		super();

	}

	public Sentence(String sentenceString) {
		super();
		this.sentenceString = sentenceString;
		this.firstSymbol = sentenceString.charAt(0);
		this.lastSymbol = sentenceString.charAt(sentenceString.length() - 1);

	}

	public Sentence(List<Word> sentence) {
		super();
		this.sentence = sentence;
		
		this.firstSymbol = sentence.get(0).getWord().charAt(0);
		this.lastSymbol = sentence.get(sentence.size() - 1).getWord()
				.charAt(sentence.get(sentence.size() - 1).getWord().length() - 1);

	}

	public Sentence(List<Word> sentence, char firstSymbol, char lastSymbol) {
		super();
		this.sentence = sentence;
		this.firstSymbol = firstSymbol;
		this.lastSymbol = lastSymbol;
	}

	public void addWordToContainer(Word word) {
		if (word.getWord().length() > 0) {
			setFirstSymbol(word.getWord().charAt(0));
			setLastSymbol(word.getWord().charAt(word.getWord().length() - 1));
			
			sentence.add(word);
		}
		
	}

	public void removeWordFromontainer(Word part) {
		sentence.remove(part);
	}

	public void defineFirstLastSymbols() {
		if (this.sentence != null) {

			this.firstSymbol = getSentence().get(0).getWord().charAt(0);
			this.lastSymbol = sentence.get(sentence.size() - 1).getWord()
					.charAt(sentence.get(sentence.size() - 1).getWord().length() - 1);
		} else {
			this.firstSymbol = this.sentenceString.charAt(0);
			this.lastSymbol = this.sentenceString.charAt(this.sentenceString.length() - 1);
		}
	}

	@Override
	public String returnTextPart() {
		String result = "";

		if (this.sentence != null) {
			for (Word word : sentence) {
				result += word.getWord() + " ";
			}
		} else {
			result = this.sentenceString;
		}
		return result;
	}

	public String getSentenceString() {
		return sentenceString;
	}

	public void setSentenceString(String sentenceString) {
		this.sentenceString = sentenceString;
	}

	public List<Word> getSentence() {
		return sentence;
	}

	public void setSentence(List<Word> sentence) {
		this.sentence = sentence;
	}

	public char getFirstSymbol() {
		return firstSymbol;
	}

	public void setFirstSymbol(char firstSymbol) {
		this.firstSymbol = firstSymbol;
	}

	public char getLastSymbol() {
		return lastSymbol;
	}

	public void setLastSymbol(char lastSymbol) {
		this.lastSymbol = lastSymbol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + firstSymbol;
		result = prime * result + lastSymbol;
		result = prime * result + ((sentence == null) ? 0 : sentence.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sentence other = (Sentence) obj;
		if (firstSymbol != other.firstSymbol)
			return false;
		if (lastSymbol != other.lastSymbol)
			return false;
		if (sentence == null) {
			if (other.sentence != null)
				return false;
		} else if (!sentence.equals(other.sentence))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sentence [sentence=" + sentence + ", firstSymbol=" + firstSymbol + ", lastSymbol=" + lastSymbol + "]";
	}

}
