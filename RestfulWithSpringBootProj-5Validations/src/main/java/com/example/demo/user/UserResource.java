package com.example.demo.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	//get /users
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAll(); 
	}
	
	//get /users/{id}
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id) {
		User user=service.findOne(id);
		//if you sending wrong id which is not available and 
		//if you are not handling then 200 ok will come  and if you handling the exception
		//then 500 Internal server error will come but this id not correct error status
		// we have to modify
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
	
		return user;
	}
	
	
	
	//post
	//input -details of user
	//output-CREATED and return the created uri
	
	//whenever we create the resource the best status to return is 201 CREATED
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=service.save(user);
		//CREATED 
		//users/{id}    //savedUser.getId()
		
		//using response entity we can return created status
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	
	
}
