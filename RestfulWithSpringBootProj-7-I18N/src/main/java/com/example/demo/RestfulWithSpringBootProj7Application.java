package com.example.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;




@SpringBootApplication
public class RestfulWithSpringBootProj7Application  {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWithSpringBootProj7Application.class, args);
	}

	@Bean
	public AcceptHeaderLocaleResolver resolver() {
	//SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
 /* @Bean//be careful about the name of the method name should be same
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}*/
	//we can remove this bean too we have to provide basename in properties file 
	
}
