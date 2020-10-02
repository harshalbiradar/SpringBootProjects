package com.springdatajpa.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.springdatajpa.dao.StudentRepository;
import com.springdatajpa.dao.StudentRepository.MyView;
import com.springdatajpa.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	
	public List<MyView> getByProfession(String profession) {
		return studentRepository.findByProfession(profession);
	}
	
	
	public long getByAge(int age) {
		return studentRepository.countByAge(age);
	}
	
	public List<Student> deleteStudents(String name) {
		return studentRepository.deleteByName(name);
	}


	public List<Student> saveStudents(List<Student> student) {
		/*
		Student studentSaved=null;
		Iterator<Student> itr=student.listIterator();
		while (itr.hasNext()) {
			Student st=itr.next();
			 studentSaved = studentRepository.save(st);
		}
		return studentSaved;
		*/
		 return studentRepository.saveAll(student);
	}
	
	
	  public Student saveStudents(Student student) {
		 return studentRepository.save(student);
	  }
	 
	  
	  public List<Student> findByMultiCondition(String profession, int age) {
		  return studentRepository.findByProfessionAndAge(profession, age);
	  }
	  
	  public List<Student> getStudentProfessionIgnoreCase(String profession) {
			return studentRepository.findByProfessionIgnoreCase(profession);
	  }
	  
	  
	  
	  public List<Object[]> getStudentInfo(){
		  return studentRepository.getStudentData();
	  }


	public List<Student> findByProfessionAndAge(String profession, int age) {
		
		return studentRepository.findByMultiCondition(profession,age);
	}
	  
	  
	  
	  
}
