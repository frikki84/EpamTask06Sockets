package by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.parser.stringOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDivicion {
	// public static final String REGEX_FOR_CODE = "(?=class\\s[A-Z]+.*\\{)";

	public static final String REGEX_FOR_CODE = "(?=\\n\\w*.*\\s\\{)";

	public static final String REGEX_FOR_PHARAGRAPH = "\\n|(\\n\\t)";

	public static final String REGEX_FOR_SENTENCE = "(?<=\\.{3}|\\.|\\?|\\!)";

	public static final String REGEX_FOR_WORD = "[\\s+]";

	public static List<String> splitStringToCodeBlocks(String string) {
		List<String> resultList = new ArrayList<>();

		Pattern pattern = Pattern.compile(REGEX_FOR_CODE);
		Matcher matcher = pattern.matcher(string);
		
		int startSubstring = 0;

		while (matcher.find()) {
			int startRegEx = matcher.start();

			String substring = string.substring(startSubstring, startRegEx);

			resultList.add(substring);

			int counterOpen = 1;
			int counterClose = 0;

			for (int i = startRegEx; i < string.length(); i++) {
				char mid = string.charAt(i);
				if (mid == '}') {
					counterClose += 1;
				}
				if (mid == '{') {
					counterOpen += 1;
				}

				if (counterOpen == counterClose) {
					String codeSubstring = string.substring(startRegEx, i);

					resultList.add(codeSubstring);

					startSubstring = i;
					break;
				}

			}
		}

		return resultList;
	}

	public static List<String> splitStringToParagraphes(List<String> list) {
		List<String> resultList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
		
			if (i % 2 == 0) {
				String stringForWork = list.get(i);

				String[] splitStrings = stringForWork.split(REGEX_FOR_PHARAGRAPH);

				for (String string : splitStrings) {
					resultList.add(string);
				}

			} else {
				resultList.add(list.get(i));

			}

		}
		
		return resultList;
	}

	public static List<String> splitStringToSentenses(String string) {

		String[] splitString = string.split(REGEX_FOR_SENTENCE);

		List<String> resultList = Arrays.asList(splitString);
		
		return resultList;

	}

	public static List<String> splitStringToWords(String string) {

		String[] splitString = string.split(REGEX_FOR_WORD);

		List<String> resultList = Arrays.asList(splitString);
		
		return resultList;

	}

}
