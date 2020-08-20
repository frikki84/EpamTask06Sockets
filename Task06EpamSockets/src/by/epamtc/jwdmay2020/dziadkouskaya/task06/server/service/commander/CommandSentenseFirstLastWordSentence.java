package by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.commander;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.ClientServerTransferObject;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Text;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.SentenceFirstLastWordsChange;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.ServiceResult;

public class CommandSentenseFirstLastWordSentence implements ServiceCommand {

	@Override
	public String createResultString(ClientServerTransferObject transferObject){

		Text text = transferObject.getText();

		ServiceResult service = new SentenceFirstLastWordsChange(text);

		String result = service.findResultOfTextOperations();

		return result;
	}

}
