package com.kani.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KaniProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaniProductAppApplication.class, args);
		System.out.println("SpringBoot Tomcat Server Start..");
	}

}
