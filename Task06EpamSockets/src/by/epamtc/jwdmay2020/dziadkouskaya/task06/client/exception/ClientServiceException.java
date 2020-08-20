package by.epamtc.jwdmay2020.dziadkouskaya.task06.client.exception;

public class ClientServiceException extends Exception {

	public ClientServiceException() {
		super();

	}

	public ClientServiceException(String message) {
		super(message);

	}

	public ClientServiceException(Exception exception) {
		super(exception);

	}

	public ClientServiceException(String message, Exception exception) {
		super(message, exception);

	}

}
