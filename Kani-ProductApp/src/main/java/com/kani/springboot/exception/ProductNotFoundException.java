package com.kani.springboot.exception;

public class ProductNotFoundException extends Exception{
	public ProductNotFoundException(String msg) {
		super(msg);
	}

}
