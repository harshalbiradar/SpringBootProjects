package com.harshalit.swaggerconfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.parameters.Parameter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";
	private static final HashSet<String> DEFAULT_PRODUCES_AND_CONSUMES = 
			new HashSet<String>(Arrays.asList("application/json","application/xml"));
	
	
	@Bean
    public Docket api() {
      ParameterBuilder parameterBuilder = new ParameterBuilder();
      parameterBuilder.name("Authorization")
              .modelRef(new ModelRef("string"))
              .parameterType("header")
              .description("JWT token")
              .required(true)
              .build();
      List<springfox.documentation.service.Parameter> parameters = new ArrayList<>();
      parameters.add(parameterBuilder.build());
      return new Docket(DocumentationType.SWAGGER_2)
    	  .groupName("public-api")
          .apiInfo(apiInfo())
          .produces(DEFAULT_PRODUCES_AND_CONSUMES)
          .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.harshalit.controller"))              
          .paths(PathSelectors.any())  
          .build()
          // Setting globalOperationParameters ensures that authentication header is applied to all APIs
          .globalOperationParameters(parameters);
    }
  

	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("JDBC-AUTH-API")
				.description("Harshal IT API Reference for developers")
				.termsOfServiceUrl("www.techtalk.in")
				.contact("harshmb96@gmail.com")
				.license("TechTalkWith_Harshal")
				.licenseUrl("harshmb96@gmail.com")
				.version("1.0")
				.build();
	}
	
	

}
