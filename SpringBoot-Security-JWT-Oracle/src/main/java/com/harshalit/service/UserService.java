package com.harshalit.service;

import java.util.Optional;

import com.harshalit.entity.User;

public interface UserService {

	public Integer saveUser(User user);
	
	public Optional<User> findByUserName(String userName);
	
}
