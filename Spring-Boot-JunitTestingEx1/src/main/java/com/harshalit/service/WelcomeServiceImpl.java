package com.harshalit.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public String getMsg() {
		return "Welcome to AshokIT.....!";
	}

}
