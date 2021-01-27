package com.harshalit.repository;

import java.io.Serializable;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.harshalit.entity.User;


public interface UserRepository extends JpaRepository<User, Serializable> {

	@Cacheable(cacheNames = "User-cache", key = "#emailAndPass")
	public User findByEmailAndPassword(String email, String temPwd);
	
	@Cacheable(cacheNames = "User-cache", key = "#email")
	public User findByEmail(String email);
	
}
