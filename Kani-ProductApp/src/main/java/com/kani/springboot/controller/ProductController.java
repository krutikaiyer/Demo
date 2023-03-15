package com.kani.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kani.springboot.entity.Product;
import com.kani.springboot.exception.ProductNotFoundException;
import com.kani.springboot.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceImpl  productServiceImpl;
	
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		if(product.getProductId()==0)
			return new ResponseEntity("Product is not there",HttpStatus.NOT_FOUND);
		
		Product product1=productServiceImpl.addProduct(product);
		return new ResponseEntity<Product>(product1, HttpStatus.OK);
	}
	@GetMapping("/viewProduct/id/{productId}")
	public ResponseEntity<Product> viewProductById(@PathVariable int productId) throws ProductNotFoundException{
		Product product1=productServiceImpl.viewProductById(productId);
		if(product1==null) {
			throw new ProductNotFoundException("Product not found for id= "+productId);
		}
		return new ResponseEntity<Product>(product1,new HttpHeaders(),HttpStatus.OK);
		
	}

}
