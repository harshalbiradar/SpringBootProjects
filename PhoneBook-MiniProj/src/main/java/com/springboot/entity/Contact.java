package com.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "CONTACTSDETAILS")
@Data
public class Contact {

	@Id
	@GeneratedValue
	@Column(name = "Contact_Id")
	private Integer contactId;
	
	@NotBlank(message = "Please enter your name")
	@Size(min = 2, max = 30, message = "Name should contain 2 to 30 characters")
	@Column(name = "Contact_Name")
	private String contactName;
	
	@NotBlank(message = "Please enter your e-mail address")
	@Email(message = "Please enter a valid e-mail address")
	@Column(name = "Contact_Email")
	private String contactEmail;
	
	@NotNull(message = "Please enter your contact number")
	@Size(min = 10 , max = 10 ,message = "In contact number must be 10 digit")
	@Pattern(regexp = "(^$|[0-9]{10})")
	@Column(name = "Contact_Number")
	private String contactNumber;
	
	@Column(name = "Contact_IsActive")
	private boolean contactIsActive;

	

}
