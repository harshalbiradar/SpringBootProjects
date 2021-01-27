package com.harshalit.entity;

import lombok.Data;

@Data
public class Product {

	private Integer productId;
	private String productName;
	private Double productPrice;
	
	public Product(Integer productId, String productName, Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public Product() {
		super();
	}
	
	
	
}
