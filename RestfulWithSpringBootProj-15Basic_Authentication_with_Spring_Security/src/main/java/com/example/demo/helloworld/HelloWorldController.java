package com.example.demo.helloworld;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

		@Autowired
		private MessageSource MessageSource;
	
		//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
		@GetMapping("/hello-world")
		public String helloWorld() {
			return "Hello-World";
		}
		
		
		@GetMapping("/hello-world-bean")
		public HelloWorldBean HelloWorldBean() {
			return new HelloWorldBean("Hello-World-Bean");
		}
	
	///hello-world/path-variable/in28minutes
		@GetMapping(path = "/hello-world/path-variable/{name}")
		public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
			return new HelloWorldBean(String.format("Hello World, %s", name));
		}

//if we want internationalized every method then we have to write in every method parameter that is not recommanded
		//spring provided alternate way
		/*
		  @GetMapping("/hello-world-internationalized") public String 
		  		helloWorldInternationalized(@RequestHeader(name = "Accept-Language",required
		  		= false) Locale locale) { return
			  MessageSource.getMessage("good.morning.message", null, locale); }
		 */
		
		@GetMapping("/hello-world-internationalized")
		public String helloWorldInternationalized() {
			return MessageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
		}
	
	
}
