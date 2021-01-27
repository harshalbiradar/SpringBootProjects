package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springboot.entity.Contact;

public interface ContactService {

	public boolean addContact(Contact contact);
	
	public Page<Contact> getAllContacts(int pageNumber);
	
	public List<Contact> getFilterContacts(String keyword);
	
	public Contact getContactById(Integer contactId);

	public boolean deleteContact(Integer contactId);

	public boolean updateContactById(Contact contact);
	
}
