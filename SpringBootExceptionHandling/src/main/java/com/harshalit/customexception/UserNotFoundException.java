package com.harshalit.customexception;

public class UserNotFoundException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4663037466850877409L;

	public UserNotFoundException(String message) {
		super(message);
	}

	
	
}
