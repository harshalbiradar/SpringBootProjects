package com.springdatajpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
//@Data
public class Student {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String profession;
	private int age;
	
	
	public Student() {
		super();
	}
	public Student(Integer id, String name, String profession, int age) {
		super();
		this.id = id;
		this.name = name;
		this.profession = profession;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.toUpperCase();
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession.toUpperCase();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", profession=" + profession + ", age=" + age + "]";
	}
	
	
	
	
}
