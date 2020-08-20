package by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.commander;


import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.ClientServerTransferObject;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Text;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.GivenLengthWord;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.server.service.ServiceResult;


public class CommandGivenLengthWord implements ServiceCommand {

	@Override
	public String createResultString(ClientServerTransferObject transferObject) {

		Text text = transferObject.getText();

		int stringLength = Integer.valueOf(transferObject.getArgsContainer().get(0));
		
		ServiceResult service = new GivenLengthWord(text, stringLength);

		String result = service.findResultOfTextOperations();

		return result;

	}

	

}
