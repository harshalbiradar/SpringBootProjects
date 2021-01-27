package com.harshalit.securityconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
				.usersByUsernameQuery("SELECT USERNAME, PASSWORD, ENABLED FROM USER WHERE USERNAME=?")
				.authoritiesByUsernameQuery("SELECT USERNAME, ROLE FROM USER WHERE USERNAME=?");
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http.authorizeRequests()
		  .anyRequest()
		  .authenticated() 
		  .and()
		  .formLogin()
		  .permitAll()
		  .and()
		  .logout() 
		  .permitAll();
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/api/auth/**","/v2/api-docs", 
	            "/configuration/ui", 
	            "/swagger-resources", 
	            "/configuration/security",
	            "/swagger-ui.html", 
	            "/webjars/**",
	            "/favicon.ico",
	            "/h2/**",
	            "/h2-console"
	           );
	}
	

}
