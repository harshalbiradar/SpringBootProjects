package com.springboot.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.entity.Contact;
import com.springboot.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean addContact(Contact contact) {
		Contact savedObj = contactRepository.save(contact);
		return savedObj.getContactId() != null;
	}

	@Override
	public Page<Contact> getAllContacts(int pageNumber) {
		//Sort sort = Sort.by(sortField);
		//sort.ascending();
		Pageable   pageable = PageRequest.of(pageNumber - 1, 5);
		return contactRepository.findByContactIsActive(true,pageable);
	}

	@Override
	public List<Contact> getFilterContacts(String keyword) {
		if(keyword!=null) {
			return contactRepository.findAll(keyword);
		}
		return null;
	}
	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = contactRepository.findById(contactId);
		if(findById.isPresent()) {
			return findById.get(); 
		}
		return null;
	}

	@Override
	public boolean deleteContact(Integer contactId) {
	
		
		if(contactId!= null) {
			//we are returning the contact object
			Contact contact = contactRepository.findById(contactId).get();
				contact.setContactIsActive(false);
				contactRepository.save(contact);
				return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean updateContactById(Contact contact) {
		Contact updateContact = contactRepository.save(contact);
		return updateContact.getContactId()!=null;
	}

	
	
	
}
