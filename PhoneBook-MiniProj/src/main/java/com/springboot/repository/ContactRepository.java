package com.springboot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Contact;

//@Repository //optional
public interface ContactRepository extends JpaRepository<Contact, Serializable> {
	/*
	@Query("SELECT c FROM Contact  c WHERE"
			+ "CONCAT(c.contactName,c.contactEmail,c.contactNumber)"
			+ " LIKE %?1%")
	*/
	//We should use entity name rather than table name.
	@Query("SELECT c FROM Contact  c WHERE c.contactName LIKE %?1%"
			+ "OR c.contactEmail LIKE %?1%"
			+ "OR c.contactNumber LIKE %?1%")
	public List<Contact> findAll(String keyword);
	
	//infront of findBy we have to write entity class property name
	public Page<Contact> findByContactIsActive(boolean contactIsActive, Pageable pageable);
	
}
