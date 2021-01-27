package com.harshalit.service;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.harshalit.customexception.ApiErrorMsg;
import com.harshalit.customexception.ProductNotFoundExcepion;

@RestController
@ControllerAdvice
public class RestGlobalExceptionHandler {

	@ExceptionHandler(value = ProductNotFoundExcepion.class)
	public ResponseEntity<ApiErrorMsg> handleProductNotFoundExcepion(){
		ApiErrorMsg error = new ApiErrorMsg(400,"No Product Found", new Date());
		return new ResponseEntity<ApiErrorMsg>(error,HttpStatus.BAD_REQUEST);
	}
	
}
