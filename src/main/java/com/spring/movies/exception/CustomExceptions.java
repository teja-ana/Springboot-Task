package com.spring.movies.exception;

import org.springframework.stereotype.Component;

@Component
public class CustomExceptions extends Exception {

	public CustomExceptions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CustomExceptions(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomExceptions(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	
	public CustomExceptions(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String printError(String error) {
		 
		
		return error;
	}


}
