package com.example.demo.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	//authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//set your configuration on auth object
		auth.inMemoryAuthentication()
		 		.withUser("tejab")
		 		.password("tejab")
		 		.roles("USER")
		 		.and()
		 		.withUser("harshal")
		 		.password("harshal")
		 		.roles("ADMIN");
				
				
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	//authorization
	
	// we have to configure most restrictive url to the least restrictive url based on order
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/").permitAll()
		.and().formLogin();
		
	}
	
	
}
