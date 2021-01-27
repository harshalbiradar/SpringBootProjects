package com.harshalit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshalit.entity.Book;
import com.harshalit.service.BookService;

@RestController
@RequestMapping("/book")
public class BookRestController {

	@Autowired
	private BookService bookService;
	
	@PostMapping(value =  "/save", consumes={"application/json"})
	public ResponseEntity<String> saveBook(@RequestBody Book book){
		String msg = null;
		boolean isSaveBook = bookService.saveBook(book);
		if(isSaveBook==true) {
			msg = "Book Saved...!";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}else {
			msg = "Failed to save Book...!";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
}
