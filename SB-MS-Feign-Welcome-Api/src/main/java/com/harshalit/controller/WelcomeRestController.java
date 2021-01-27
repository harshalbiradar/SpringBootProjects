package com.harshalit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshalit.GreetApiClient;

@RestController
public class WelcomeRestController {

	@Autowired
	private GreetApiClient greetApiClient;
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		String finalResponse = null;
		String welcomeMsg = "Welcome to AhokIT...!";
		//access GREET-API
		String greetMsg = greetApiClient.invokeGreetApi();
		return greetMsg+" "+welcomeMsg;
	}
	
	
}
