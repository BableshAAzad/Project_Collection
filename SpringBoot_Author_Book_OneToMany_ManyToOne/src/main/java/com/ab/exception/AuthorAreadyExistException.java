package com.ab.exception;

public class AuthorAreadyExistException extends RuntimeException {
	private String message;

	public AuthorAreadyExistException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
