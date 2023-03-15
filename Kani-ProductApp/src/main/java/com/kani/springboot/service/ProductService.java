package com.kani.springboot.service;

import java.util.List;

import com.kani.springboot.entity.Product;
import com.kani.springboot.exception.ProductNotFoundException;

public interface ProductService {
	
	public Product addProduct(Product product);
	
	public Product viewProductById(int productId) throws ProductNotFoundException;

}
