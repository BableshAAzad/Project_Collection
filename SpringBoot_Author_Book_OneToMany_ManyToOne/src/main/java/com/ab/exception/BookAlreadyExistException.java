package com.ab.exception;

public class BookAlreadyExistException extends RuntimeException {
	private String message;

	public BookAlreadyExistException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
