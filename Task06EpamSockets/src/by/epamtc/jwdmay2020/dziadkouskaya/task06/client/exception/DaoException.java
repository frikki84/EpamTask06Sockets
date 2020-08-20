package by.epamtc.jwdmay2020.dziadkouskaya.task06.client.exception;


public class DaoException extends Exception {

	public DaoException() {
		super();

	}

	public DaoException(String message) {
		super(message);

	}

	public DaoException(Exception exception) {
		super(exception);

	}

	public DaoException(String message, Exception exception) {
		super(message, exception);

	}

}
