package com.harshalit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "User_ID")
	private Integer userId;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "ENABLED")
	private Integer enabled;
	

	
}
