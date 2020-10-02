package com.example.demo.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class FilteringControlling {

	@GetMapping("/filtering")
	public SomeBean retriveSomeBean() {
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> listOfSomeBean(){
		return Arrays.asList(new SomeBean("value11","value12","value13"),
							 new SomeBean("value21","value22","value23"));
	}
	
	
}
