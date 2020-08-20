package by.epamtc.jwdmay2020.dziadkouskaya.task06.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserRequest implements Serializable {
	private String sourcePath;
	
	private TextOperationType type;
	
	private List<String> argsContainer;

	public UserRequest() {
		super();
	}

	public UserRequest(String sourcePath, TextOperationType type) {
		super();
		this.sourcePath = sourcePath;
		this.type = type;
	}

	public UserRequest(String sourcePath, TextOperationType type, String... args) {
		super();

		this.sourcePath = sourcePath;
		this.type = type;

		argsContainer = new ArrayList();

		for (String arg : args) {
			argsContainer.add(arg);
		}
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
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
		result = prime * result + ((sourcePath == null) ? 0 : sourcePath.hashCode());
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
		UserRequest other = (UserRequest) obj;
		if (argsContainer == null) {
			if (other.argsContainer != null)
				return false;
		} else if (!argsContainer.equals(other.argsContainer))
			return false;
		if (sourcePath == null) {
			if (other.sourcePath != null)
				return false;
		} else if (!sourcePath.equals(other.sourcePath))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRequest [sourcePath=" + sourcePath + ", type=" + type + ", argsContainer=" + argsContainer + "]";
	}

}
