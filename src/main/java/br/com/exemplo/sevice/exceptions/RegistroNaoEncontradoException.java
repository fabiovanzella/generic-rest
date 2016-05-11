package br.com.exemplo.sevice.exceptions;

public class RegistroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 8775397947667743643L;

	public RegistroNaoEncontradoException() {
		super();
	}

	public RegistroNaoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RegistroNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public RegistroNaoEncontradoException(String message) {
		super(message);
	}

	public RegistroNaoEncontradoException(Throwable cause) {
		super(cause);
	}
}
