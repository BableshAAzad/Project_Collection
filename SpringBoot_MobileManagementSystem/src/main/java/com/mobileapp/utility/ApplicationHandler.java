package com.mobileapp.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mobileapp.exception.MobileAllReadyExistException;
import com.mobileapp.exception.MobileNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {
        @ExceptionHandler
        public ResponseEntity<ResponseStructure<String>> mobileAllReadyPresentException(MobileAllReadyExistException mobileAllReadyExistException){
        	ResponseStructure<String> responseStructure = new ResponseStructure<String>();
        	responseStructure.setStatusCode(HttpStatus.FOUND.value());
        	responseStructure.setMessage("Mobile object is already exist in database");
        	responseStructure.setData(mobileAllReadyExistException.getMessage());
        	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.FOUND);
        }
        
        @ExceptionHandler
        public ResponseEntity<ResponseStructure<String>> mobileNotFoundException(MobileNotFoundException mobileNotFoundException){
        	ResponseStructure<String> responseStructure = new ResponseStructure<String>();
        	responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        	responseStructure.setMessage("Mobile object not found in database");
        	responseStructure.setData(mobileNotFoundException.getMessage());
        	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
        }
}
