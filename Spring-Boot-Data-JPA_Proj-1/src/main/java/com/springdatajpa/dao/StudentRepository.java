package com.springdatajpa.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springdatajpa.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	//static projection
	interface MyView{
		String getName();
		String getProfession();
		int getAge();
	}
	
	public List<MyView> findByProfession(String profession);
	
	
	public long countByAge(int age);
	
	@Transactional()
	public List<Student> deleteByName(String name);
	
	//multi condition
	public List<Student> findByProfessionAndAge(String profession,int age);
	
	//we have ignore case we can apply
	public List<Student> findByProfessionIgnoreCase(String profession);


	@Query("select s.name,s.profession from Student s")
	public List<Object[]> getStudentData();

	@Query("select s from Student s where s.profession=?1 or s.age=?2")
	public List<Student> findByMultiCondition(String profession, int age);
	

	
	
	
	
	
	
	
	
}
