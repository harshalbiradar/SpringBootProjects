package com.example.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;




@SpringBootApplication
public class RestfulWithSpringBootProj15Application  {

	//for content negotiation we need jackson-dataformat-xml jar through this we can easy to request or response in any format
	
	// for swagger documentation we need to add springfox-swagger2 and  springfox-swagger-ui jar
	//Enhancing the swagger doc
	
	//for Actuator we need to add spring-boot-starter-actuator and spring-data-rest-hal-browser jar
	
	public static void main(String[] args) {
		SpringApplication.run(RestfulWithSpringBootProj15Application.class, args);
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
