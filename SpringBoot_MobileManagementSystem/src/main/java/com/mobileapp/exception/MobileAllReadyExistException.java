package com.mobileapp.exception;

public class MobileAllReadyExistException extends RuntimeException {
	private String message;

	public MobileAllReadyExistException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
