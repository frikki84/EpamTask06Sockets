package by.epamtc.jwdmay2020.dziadkouskaya.task06.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClientServerTransferObject implements Serializable {
	private Text text;
	private TextOperationType type;
	private List<String> argsContainer;
	

	public ClientServerTransferObject() {
		super();
		
	}

	public ClientServerTransferObject(Text text, TextOperationType type) {
		super();
		this.text = text;
		this.type = type;
		this.argsContainer = new ArrayList<String>();
	}

	public ClientServerTransferObject(Text text, TextOperationType type, List<String> argsContainer) {
		super();
		this.text = text;
		this.type = type;
		this.argsContainer = argsContainer;
	}

	
	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public TextOperationType getType() {
		return type;
	}

	public void setType(TextOperationType type) {
		this.type = type;
	}

	public List<String> getArgsContainer() {
		return argsContainer;
	}

	public void setArgsContainer(List<String> argsContainer) {
		this.argsContainer = argsContainer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((argsContainer == null) ? 0 : argsContainer.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ClientServerTransferObject other = (ClientServerTransferObject) obj;
		if (argsContainer == null) {
			if (other.argsContainer != null)
				return false;
		} else if (!argsContainer.equals(other.argsContainer))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass() + " [text=" + text + ", type=" + type + ", argsContainer=" + argsContainer + "]";
	}


}
