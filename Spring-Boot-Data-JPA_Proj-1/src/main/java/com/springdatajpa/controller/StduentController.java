package com.springdatajpa.controller;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springdatajpa.dao.StudentRepository.MyView;
import com.springdatajpa.model.Student;
import com.springdatajpa.service.StudentNotFoundException;
import com.springdatajpa.service.StudentService;

@RestController
public class StduentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> retriveAllStudents(){
		return studentService.getAll();
	}
	
	
	@GetMapping("/students/{profession}")
	public List<MyView> retriveByProfession(@PathVariable String profession){
		
		List<MyView> students = studentService.getByProfession(profession.toUpperCase());
		if(students.isEmpty()) {
			throw new StudentNotFoundException("profession-"+profession);
		}
		return students;
	}
	
	@GetMapping("/count/{age}")
	public String getCountByAge(@PathVariable int age) {
		long count=studentService.getByAge(age);
		return "Total no of records-"+count;
	}
	
	@DeleteMapping("/delete/{name}")
	public List<Student> removeByName(@PathVariable String name) {
		return studentService.deleteStudents(name.toUpperCase());
	}
	
	
	@PostMapping("/students")
	public String createUser(@RequestBody List<Student> student) {
		List<Student> savedStudent=studentService.saveStudents(student);
	return "Students record is stored";
	}
	
	@PostMapping("/student")
	public ResponseEntity<Object> createUser(@RequestBody Student student) {
		
		Student savedStudent=studentService.saveStudents(student);
		
		//using response entity we can return created status
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequestUri()
						.path("/{id}")
						.buildAndExpand(savedStudent.getId())
						.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	
	//by using query method
	@GetMapping("/students/query")
	public List<Object[]> getStudentsCustomQuery(){
		  return studentService.getStudentInfo();
	}
	
	@GetMapping("/getByProfessionAndAge/{profession}/{age}")
	public List<Student> getByProfessionAndAge(@PathVariable String profession,@PathVariable int age){
		return studentService.findByProfessionAndAge(profession,age);
	}

	
}
