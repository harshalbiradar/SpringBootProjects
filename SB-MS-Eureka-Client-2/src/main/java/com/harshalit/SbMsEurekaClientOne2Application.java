package com.harshalit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
public class SbMsEurekaClientOne2Application {

	public static void main(String[] args) {
		SpringApplication.run(SbMsEurekaClientOne2Application.class, args);
	}

}
