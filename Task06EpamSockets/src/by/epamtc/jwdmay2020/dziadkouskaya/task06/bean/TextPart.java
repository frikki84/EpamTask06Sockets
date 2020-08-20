package by.epamtc.jwdmay2020.dziadkouskaya.task06.bean;

import java.io.Serializable;
import java.util.List;

public class TextPart implements Serializable {
	private String part;
	
	List<TextPart> partsContainer;

	public TextPart() {
		super();
		
	}

	public TextPart(String part) {
		super();
		this.part = part;
	}

	public TextPart(String part, List<TextPart> partsContainer) {
		super();
		this.part = part;
		this.partsContainer = partsContainer;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public List<TextPart> getPartsContainer() {
		return partsContainer;
	}

	public void setPartsContainer(List<TextPart> partsContainer) {
		this.partsContainer = partsContainer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((part == null) ? 0 : part.hashCode());
		result = prime * result + ((partsContainer == null) ? 0 : partsContainer.hashCode());
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
		TextPart other = (TextPart) obj;
		if (part == null) {
			if (other.part != null)
				return false;
		} else if (!part.equals(other.part))
			return false;
		if (partsContainer == null) {
			if (other.partsContainer != null)
				return false;
		} else if (!partsContainer.equals(other.partsContainer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TextPart [part=" + part + ", partsContainer=" + partsContainer + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
