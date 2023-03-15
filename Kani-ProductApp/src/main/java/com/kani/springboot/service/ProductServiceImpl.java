package com.kani.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kani.springboot.entity.Product;
import com.kani.springboot.exception.ProductNotFoundException;
import com.kani.springboot.repository.ProductRepository;




@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {

		Product product1=productRepository.save(product);
		return product1;
	}

	@Override
	public Product viewProductById(int productId) throws ProductNotFoundException {
		if(!productRepository.existsById(productId))
			throw new ProductNotFoundException("Product not found");
		Optional<Product> product=productRepository.findById(productId);
		return  productRepository.getById(productId);
		
	}

}
