package com.harshalit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("msg", "Welcome to the HarshalIt....!!");
		String str=null;
		str.length();
		return "welcome";
	}
	
	
	//this is the specific controller based exception handling
/*	
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Model model) {
		model.addAttribute("errorMsg", "This site is temporary not available please try after some time...!!");
		return "error";
	}
	
*/
	
}
