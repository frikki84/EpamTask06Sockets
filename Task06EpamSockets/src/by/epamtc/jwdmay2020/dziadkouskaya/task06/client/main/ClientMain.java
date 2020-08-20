package by.epamtc.jwdmay2020.dziadkouskaya.task06.client.main;

import java.io.IOException;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.TextOperationType;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.UserRequest;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.controller.ClientController;

public class ClientMain {
	public static void main(String[] args) {
		String sourcePath = "resources\\source_file.txt";
		int portNumber = 4004;

		UserRequest request = new UserRequest(sourcePath,
				TextOperationType.IN_INTERROGATIVE_SENTENCE_GIVEN_LENGTH_WORDS, "2");

		ClientController clientController = new ClientController();

		try {
			clientController.receiveInformationFromFileToServer(request, portNumber);
			
		} catch (IOException e) {

			e.printStackTrace();
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
