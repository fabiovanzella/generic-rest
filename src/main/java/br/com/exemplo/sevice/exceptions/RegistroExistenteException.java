package br.com.exemplo.sevice.exceptions;

public class RegistroExistenteException extends RuntimeException {

	private static final long serialVersionUID = 2527265124573274973L;

	public RegistroExistenteException() {
		super();
	}

	public RegistroExistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RegistroExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public RegistroExistenteException(String message) {
		super(message);
	}

	public RegistroExistenteException(Throwable cause) {
		super(cause);
	}
}
