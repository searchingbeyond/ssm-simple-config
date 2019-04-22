package cn.ganlixin.exception;

public class UnauthorizeException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnauthorizeException() {
		super();
	}

	public UnauthorizeException(String message) {
		super(message);
	}
}
