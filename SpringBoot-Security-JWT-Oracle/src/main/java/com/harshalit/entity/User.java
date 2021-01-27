package com.harshalit.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "UserTab")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "UserId")
	private Integer userId;
	@Column(name = "UserName")
	private String userName;
	@Column(name = "Password")
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name = "RolesTab",
			joinColumns = @JoinColumn (name = "userId")
			)
	private Set<String> roles;
	
	
	
	
	
	
}
