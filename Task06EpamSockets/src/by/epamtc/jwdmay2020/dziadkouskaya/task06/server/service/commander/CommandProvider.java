package by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.commander;

import java.util.HashMap;
import java.util.Map;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.ClientServerTransferObject;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.TextOperationType;



public class CommandProvider {
	private Map<TextOperationType, ServiceCommand> commands = new HashMap();

	public CommandProvider() {
		commands.put(TextOperationType.SENTENCES_BY_WORD_COUNT_SORTING, new CommandSentenceByWordCountSorting());
		commands.put(TextOperationType.IN_INTERROGATIVE_SENTENCE_GIVEN_LENGTH_WORDS, new CommandGivenLengthWord());
		commands.put(TextOperationType.SENTENCE_FIRST_LAST_WORDS_CHANGE, new CommandSentenseFirstLastWordSentence());
		
	}
	
	public ServiceCommand returnRightCommand(ClientServerTransferObject transferObject) {
		TextOperationType type;
		ServiceCommand command;
		
		type = transferObject.getType();
		
		command = commands.get(type);
		
		return command;
	}
	
	

}
