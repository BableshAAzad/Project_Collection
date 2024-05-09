package com.ab.exception;

public class AuthorNotFoundException extends RuntimeException {
	private String message;

	public AuthorNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
