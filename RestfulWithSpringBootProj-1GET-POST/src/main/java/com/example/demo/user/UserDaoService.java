package com.example.demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository
public class UserDaoService {

	private static List<User> users=new ArrayList<>();
	
	private static int userCount=3;
	
	static {
		users.add(new User(1,"Harshal",new Date()));
		users.add(new User(2, "Kapil", new Date()));
		users.add(new User(3, "Khushal", new Date()));
	}
	
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
}
