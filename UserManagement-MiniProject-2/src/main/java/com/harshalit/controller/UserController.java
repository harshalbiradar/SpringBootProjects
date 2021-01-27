package com.harshalit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harshalit.entity.User;
import com.harshalit.service.UserService;
//@RestController
@Controller
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loginInfo", new User());
		return "loginPage";
	}
	
	@GetMapping("/registerPage")
	public String registerPage(Model model) {
		model.addAttribute("loginInfo", new User());
		Map<Integer, String> country = userService.getCountry();
		model.addAttribute("countryList", country);
		return "registerPage";
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> registerUser(@RequestBody User user) {
	    boolean registerUser = userService.registerUser(user);
	    
	    
	return null;
	}
	
}
