package com.harshalit.customexception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerExcetion(Model model) {
		model.addAttribute("errorMsg", "Some problem occured please try after sometime..!!");
		return "error";
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public String handleUserNotFoundException(Model model) {
		model.addAttribute("errorMsg", "User not found with this id please try once again..!!");
		return "error";
	}
}
