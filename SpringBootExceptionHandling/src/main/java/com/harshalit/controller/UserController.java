package com.harshalit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.harshalit.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/finduser/{userId}")
	public String findUserById(@PathVariable Integer userId, Model model) {
		String findUserById = userService.findUserById(userId);
		model.addAttribute("user", findUserById);
		return "userInfo";
	}
	
}
