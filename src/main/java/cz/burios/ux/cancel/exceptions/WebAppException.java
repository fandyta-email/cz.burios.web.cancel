package cz.burios.ux.cancel.exceptions;

public class WebAppException extends RuntimeException {
	private static final long serialVersionUID = 3239279012042571262L;

	private String errorMsg;

	public WebAppException(String errorMsg) {
		super(errorMsg);
		this.setErrorMsg(errorMsg);
	}

	public WebAppException(String errorMsg, Throwable error) {
		super(errorMsg, error);
		this.setErrorMsg(errorMsg);
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
