package by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.serverlink;

import java.util.List;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.ClientServerTransferObject;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Text;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.TextOperationType;

public class ClientServerTransferObjectCreation {
	
	public static ClientServerTransferObject createClientServerTransferObject(Text text, TextOperationType type,
			List<String> argsContainer) {
		
		ClientServerTransferObject transferObject = null;

		if (argsContainer == null || argsContainer.isEmpty()) {
			transferObject = new ClientServerTransferObject(text, type);
			
		} else {
			transferObject = new ClientServerTransferObject(text, type, argsContainer);
		}

		
		return transferObject;
	}

}
