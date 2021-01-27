package com.harshalit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.harshalit.filter.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService; 
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private InvalidUserAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private SecurityFilter securityFilter; 
	
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
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
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user/save","/user/login").permitAll()
		.anyRequest().authenticated()
		.and()
		
		.exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS) //if you are not writing it becomes stateful
		.and()
		//register filter for second request onwards
		.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
		;
		
	}
	
	
	
}
