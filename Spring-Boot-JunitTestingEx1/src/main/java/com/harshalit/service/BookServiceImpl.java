package com.harshalit.service;

import org.springframework.stereotype.Service;

import com.harshalit.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public boolean saveBook(Book book) {
		if(book!=null) {
			return true;
		}
		return false;
	}

	
	
	
	
	
}
