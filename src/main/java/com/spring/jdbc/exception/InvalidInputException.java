package com.spring.jdbc.exception;

public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 1L;
	private  String message;

	public InvalidInputException(String message) {
		 super(message);
		 this.message = message;
	}
	
	

}
