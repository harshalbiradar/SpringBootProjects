package com.harshalit.service;

import org.springframework.stereotype.Service;

import com.harshalit.customexception.UserNotFoundException;


@Service
public class UserServiceImpl implements UserService {

	@Override
	public String findUserById(Integer id) {
		if(id==100) {
			return "UserName:: Harshal Biradar && UserId:: "+id;
		}else {
			throw new UserNotFoundException("User not found with id: "+id);
		}
	}

}
