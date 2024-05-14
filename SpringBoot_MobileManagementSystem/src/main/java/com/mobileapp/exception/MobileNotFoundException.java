package com.mobileapp.exception;

public class MobileNotFoundException extends RuntimeException {
	private String message;

	public MobileNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
