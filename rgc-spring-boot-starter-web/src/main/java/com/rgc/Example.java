package com.rgc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration
						// @ComponentScan
public class Example {

	@RequestMapping("/")
	String home() {
		return "hello boss";
	}

	public static void main(String[] args) {
		SpringApplication.run(Example.class, args);
	}

}
