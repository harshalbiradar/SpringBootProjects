package com.harshalit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching    //To enable the caching
public class UserManagementMiniProjectUsingRest3Application {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementMiniProjectUsingRest3Application.class, args);
	}

}
