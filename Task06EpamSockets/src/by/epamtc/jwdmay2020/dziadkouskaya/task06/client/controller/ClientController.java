package by.epamtc.jwdmay2020.dziadkouskaya.task06.client.controller;

import java.io.IOException;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.ClientServerTransferObject;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Text;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.UserRequest;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.dao.InfoFromFileDAO;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.dao.InfoFromSourceDAO;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.exception.ClientServiceException;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.parser.InfoFromDaoToService;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.parser.TextNotifier;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.serverlink.ClientServerTransferObjectCreation;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.serverlink.ServerLink;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.validation.ClientValidation;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.view.ConsoleWriter;

public class ClientController {

	public void receiveInformationFromFileToServer(UserRequest request, int portNumber)
			throws IOException, ClientServiceException {
		
		ClientValidation.checkUserRequestParametrs(request);

		String filePath = request.getSourcePath();

		InfoFromSourceDAO infoFromFileDAO = new InfoFromFileDAO();

		String infoFromFile = infoFromFileDAO.takeInfoFromSource(filePath);

		InfoFromDaoToService textNotifier = new TextNotifier();
		
		Text text = textNotifier.returnInformationForTextAnalysis(infoFromFile);

		ClientServerTransferObject transferObject = ClientServerTransferObjectCreation
				.createClientServerTransferObject(text, request.getType(), request.getArgsContainer());

		ServerLink link = new ServerLink(portNumber);

		String resultString = link.workWithServer(transferObject);

		if (resultString != null & resultString.length() > 0) {

			ConsoleWriter.printInfoToConsole("Result is\n" + resultString);

		} else {

			ConsoleWriter.printInfoToConsole("There are no answers");
		}

	}

}
