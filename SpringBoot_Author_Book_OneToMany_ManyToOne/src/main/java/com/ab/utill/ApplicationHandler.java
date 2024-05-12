package com.ab.utill;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ab.exception.AuthorNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> actorNotFoundException(
			AuthorNotFoundException actAuthorNotFoundException) {
		ErrorStructure<String> errorStructure = new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setData("Actor not present in database");
		errorStructure.setErrorMessage(actAuthorNotFoundException.getMessage());
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}

}