package com.harshalit.service;

import org.springframework.stereotype.Service;

import com.harshalit.customexception.ProductNotFoundExcepion;
import com.harshalit.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public Product findByProductId(Integer pId) {
		if(pId==10) {
			return new Product(pId,"Lenovo-Laptop",45000.00);
		}else {
			throw new ProductNotFoundExcepion("Product not found with id "+pId);
		}
	}

}
