package by.epamtc.jwdmay2020.dziadkouskaya.task06.bean;

import java.io.Serializable;
import java.util.List;

public class CodeBlock extends Paragraph implements Serializable{
	public static final char FIRST_SYMBOL = '{';
	public static final char LAST_SYMBOL = '}';
	
	
	public CodeBlock() {
		super();
		
	}
	public CodeBlock(List<Sentence> paragraph) {
		super(paragraph);
		
	}
	
	
	
	
	
	
	
	

}
