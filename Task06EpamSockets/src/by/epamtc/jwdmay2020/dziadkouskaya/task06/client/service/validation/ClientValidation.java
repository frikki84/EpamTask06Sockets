package by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.validation;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.TextOperationType;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.UserRequest;
import by.epamtc.jwdmay2020.dziadkouskaya.task06.client.exception.ClientServiceException;

public class ClientValidation {
	public static void checkUserRequestParametrs(UserRequest request) throws ClientServiceException {
		TextOperationType userRequestType = request.getType();

		switch (userRequestType) {
		
		case IN_INTERROGATIVE_SENTENCE_GIVEN_LENGTH_WORDS:
			if (request.getArgsContainer() == null || request.getArgsContainer().size() != 1) {
				throw new ClientServiceException("UserRequest doesn't contain all the parameters");
			}
			break;

		}
		

	}

}
