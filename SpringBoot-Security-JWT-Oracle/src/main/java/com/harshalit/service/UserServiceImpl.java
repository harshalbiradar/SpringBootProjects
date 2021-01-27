package com.harshalit.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.harshalit.entity.User;
import com.harshalit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	
	//Encode Password
	@Override
	public Integer saveUser(User user) {

		user.setPassword(pwdEncoder.encode(user.getPassword()));
		return userRepo.save(user).getUserId();
	}

	//get user by userName
	@Override
	public Optional<User> findByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> isUser = findByUserName(username);
		if(isUser.isEmpty())
			throw new UsernameNotFoundException("User Not Exists");
		
		//read user from db
		User user = isUser.get();
		
		return new org.springframework.security.core.userdetails.User(
				username, 
				user.getPassword(), 
				user.getRoles().stream()
				.map(roles->new SimpleGrantedAuthority(roles))
				.collect(Collectors.toList())
				);
	}
	
	
}

