package com.example.demo.exception;

import java.util.Date;


public class ExceptionResponse {
		//timestamp   when the exception happen
		//message 
		//details
	//in your organization if we want to develop standard error structure
	//if you want response back in this specific format //how can we do that 
	
	//ResponseEntityExceptionHandler using this class we can modify structure
	private Date timestamp;
	private String message;
	private String details;
	
	
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}
	
	
	
	
}
