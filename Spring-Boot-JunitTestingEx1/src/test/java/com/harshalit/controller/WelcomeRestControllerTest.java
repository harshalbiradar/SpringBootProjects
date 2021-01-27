package com.harshalit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.harshalit.service.WelcomeService;

@WebMvcTest(WelcomeRestController.class)
public class WelcomeRestControllerTest {

	@Autowired
	private MockMvc  mocMvc;
	
	@MockBean
	private WelcomeService  welcomeService;
	
	@Test
	public void test_welcomeMsg() throws Exception {
		
		when(welcomeService.getMsg()).thenReturn("Welcome to AsholIT.....!");
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");
		MvcResult mvcResult = mocMvc.perform(requestBuilder).andReturn();
		
		//String responseStr = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		
	}
	
	
	
}
