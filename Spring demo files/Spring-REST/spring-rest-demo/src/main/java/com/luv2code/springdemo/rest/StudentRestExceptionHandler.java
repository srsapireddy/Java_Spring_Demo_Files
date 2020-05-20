package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 480
@ControllerAdvice
public class StudentRestExceptionHandler {
	
	// add exception handling code here

	// 476
	// Add an exception handler using @ExceptionHandler
	// ResponseEntity<StudentErrorResponse> --> Type of response body
	// StudentNotFoundException --> Exception type to handle/catch
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		
		// create a StudentErrorResponse --> Setting appropriate values on ErrorResponse object
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	// 478
	// add another exception handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		// create a StudentErrorResponse --> Setting appropriate values on ErrorResponse object
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
				
		// return ResponseEntity
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
}
