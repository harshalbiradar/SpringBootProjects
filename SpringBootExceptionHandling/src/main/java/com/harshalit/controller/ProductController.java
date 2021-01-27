package com.harshalit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.harshalit.entity.Product;
import com.harshalit.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/getproduct/{pId}", produces = {"application/json"})
	public Product getProductDataById(@PathVariable Integer pId) {
		return productService.findByProductId(pId);
	}
	
	
}
