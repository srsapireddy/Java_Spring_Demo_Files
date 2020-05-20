package com.luv2code.springdemo.rest;

// 474
// Can use this in REST Service when its time to throw an exception if the student ID is a bad student ID or if we can't find the given student
public class StudentNotFoundException extends RuntimeException {

	// Generate the constructor from the Super class
	public StudentNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public StudentNotFoundException(String arg0) {
		super(arg0);
		
	}

	public StudentNotFoundException(Throwable arg0) {
		super(arg0);
		
	}
	
}
