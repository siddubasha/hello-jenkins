package com.siddu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHelloApplication.class, args);
	}
	
	@GetMapping("/hi")
	public String hello() {
		return "Hello Siddu, Jenkins CI/CD implemented sucessfully";
		
	}

}
