package by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service;

import java.util.ArrayList;
import java.util.Arrays;

/*Вывести все предложения заданного текста в порядке возрастания количества слов в предложении*/

import java.util.List;
import java.util.Map;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Sentence;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Text;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.listcreate.ListCreation;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.listcreate.StringCreation;


public class SentenceByWordCountSorting implements ServiceResult {
	private Text text;

	public SentenceByWordCountSorting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SentenceByWordCountSorting(Text text) {
		super();
		this.text = text;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
		
	}

	@Override
	public String findResultOfTextOperations() {
		List<Sentence> sentences = ListCreation.createSentenceList(this.text);
		
		insertionSort(sentences);
		
		String result = StringCreation.createStringFromSentenceList(sentences);

		return result;
	}

	
	public  void insertionSort(List<Sentence> array) {  
	    for (int i = 1; i < array.size(); i++) {
	        int current = array.get(i).getSentence().size();
	        Sentence middl = array.get(i);
	        int j = i - 1;
	        while(j >= 0 && current < array.get(j).getSentence().size()) {
	            array.set((j + 1), array.get(j));
	        	j--;
	        }
	        array.set((j + 1), middl);
	       }
	}
	

	@Override
	public String toString() {
		return "SentenceByWordCountSorting [text=" + text + "]";
	}
	
	

}
