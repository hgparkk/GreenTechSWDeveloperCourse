package com.spring.study.common.exception;

public class BizException extends Exception {
	private String errCode;

	public BizException(String message) {
		super(message);
	}

	public BizException(String message, String errCode) {
		super(message);
		this.errCode = errCode;
	}

	@Override
	public String toString() {
		return "BizException [errCode=" + errCode + "]";
	}
}