package com.harshalit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	
	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome</h1>");
	}
	
	
	@GetMapping("/user")
	public String user() {
		return ("<h1>Welcome User</h1>");
	}
	
	//only for admin
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Welcome Admin</h1>");
	}
	
	
	
}
