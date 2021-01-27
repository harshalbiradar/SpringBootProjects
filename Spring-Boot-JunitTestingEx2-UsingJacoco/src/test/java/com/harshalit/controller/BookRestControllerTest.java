package com.harshalit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshalit.entity.Book;
import com.harshalit.service.BookService;

@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {

	
	//we have to check target folder in that it will generate report in site folder check the html file
	
	@Autowired
	private MockMvc mockMvc;
	//mockmvc is used for performing the unit testing 
	
	@MockBean
	private BookService bookService;
	/*
	@Test
	public void testBook() throws Exception {
		Book b = new Book("100","Spring", "450");
		
		ObjectMapper mapper = new ObjectMapper();
		String bookJson = mapper.writeValueAsString(b);
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/book/save").contentType("application/json").content(bookJson);
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(201, status);
		
	} 
	*/
	@Test
	public void test_1_Book() throws Exception {
		Book b = new Book("100","Spring", "450");
		when(bookService.saveBook(b)).thenReturn(true);
		ObjectMapper mapper = new ObjectMapper();
		String bookJson = mapper.writeValueAsString(b);
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/book/save").contentType("application/json").content(bookJson);
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(201, status);
		
	} 
	
	@Test
	public void test_2_Book() throws Exception {
		Book b = new Book("100","Spring", "450");
		when(bookService.saveBook(b)).thenReturn(false);
		ObjectMapper mapper = new ObjectMapper();
		String bookJson = mapper.writeValueAsString(b);
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/book/save").contentType("application/json").content(bookJson);
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(400, status);
		
	} 
	
}
