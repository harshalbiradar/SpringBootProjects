package com.harshalit;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("GREET-API")//service api name
public interface GreetApiClient {

	@GetMapping("/greet")
	public String invokeGreetApi();
	
}
