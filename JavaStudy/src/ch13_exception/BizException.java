package ch13_exception;

public class BizException extends Exception{
	
	private String errCode;
	
	public BizException() {
		super();
	}

	public BizException(String message, String errCode) {
		super(message);
		this.errCode = errCode;
	}
	
	public String getErrCode() {
		return this.errCode;
	}
}