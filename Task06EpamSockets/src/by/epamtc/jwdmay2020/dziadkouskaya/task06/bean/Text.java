package by.epamtc.jwdmay2020.dziadkouskaya.task06.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Text implements TextPartInterface, Serializable {

	private String text;

	List<Paragraph> allText = new ArrayList();

	public Text() {
		super();

	}

	public Text(String text) {
		super();
		this.text = text;
	}

	public Text(List<Paragraph> allText) {
		super();
		this.allText = allText;
	}

	public void addParagraphToContainer(Paragraph paragraph) {
		allText.add(paragraph);
	}

	public void removeParagraphFromontainer(Paragraph paragraph) {
		allText.remove(paragraph);
	}

	@Override
	public String returnTextPart() {
		String result = "";

		if (this.allText != null) {

			for (Paragraph paragraph : allText) {
				result += paragraph.returnTextPart();
			}
		} else {
			result = getText();
		}
		return result;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Paragraph> getAllText() {
		return allText;
	}

	public void setAllText(List<Paragraph> allText) {
		this.allText = allText;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allText == null) ? 0 : allText.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Text other = (Text) obj;
		if (allText == null) {
			if (other.allText != null)
				return false;
		} else if (!allText.equals(other.allText))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Text [allText=" + allText + "]";
	}

}
