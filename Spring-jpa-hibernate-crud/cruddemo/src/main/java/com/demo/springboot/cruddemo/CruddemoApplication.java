package com.demo.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.demo.springboot.cruddemo.entity")
public class CruddemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}
