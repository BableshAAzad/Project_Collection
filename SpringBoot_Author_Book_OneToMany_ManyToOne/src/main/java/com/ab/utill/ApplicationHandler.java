package com.ab.utill;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ab.exception.AuthorAreadyExistException;
import com.ab.exception.AuthorNotFoundException;
import com.ab.exception.BookAlreadyExistException;
import com.ab.exception.BookNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> actorAreadyPresent(AuthorAreadyExistException authorAreadyExistException){
		ErrorStructure<String> errorStructure = new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.FOUND.value());
		errorStructure.setData("Actor alread exist in database");
		errorStructure.setErrorMessage(authorAreadyExistException.getMessage());
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> actorNotFoundException(
			AuthorNotFoundException actAuthorNotFoundException) {
		ErrorStructure<String> errorStructure = new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setData("Actor not present in database");
		errorStructure.setErrorMessage(actAuthorNotFoundException.getMessage());
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}
	
   @ExceptionHandler
   public ResponseEntity<ErrorStructure<String>> bookAlreadyPresentException(BookAlreadyExistException bookAlreadyExistException){
	   ErrorStructure<String> errorStructure = new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.FOUND.value());
		errorStructure.setData("Book already exist in database");
		errorStructure.setErrorMessage(bookAlreadyExistException.getMessage());
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.FOUND);
   }
   
   @ExceptionHandler
   public ResponseEntity<ErrorStructure<String>> bookAlreadyPresentException(BookNotFoundException bookNotFoundException){
	   ErrorStructure<String> errorStructure = new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setData("Book not present in database");
		errorStructure.setErrorMessage(bookNotFoundException.getMessage());
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
   }

}