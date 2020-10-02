package com.example.demo;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//configure swagger
@Configuration
//Enable swagger
@EnableSwagger2
public class SwaggerConfig {

	
	//create bean -Docket
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	} 
	
	//swagger2
	//all the paths
	// all the api
	
	
}
